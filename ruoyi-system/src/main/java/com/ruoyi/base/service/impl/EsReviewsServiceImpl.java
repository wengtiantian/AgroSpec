package com.ruoyi.base.service.impl;

import java.util.List;
import java.util.Map;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.utils.SQApiClient;
import com.ruoyi.utils.SQResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.EsReviewsMapper;
import com.ruoyi.base.domain.EsReviews;
import com.ruoyi.base.service.IEsReviewsService;
import com.ruoyi.subject.domain.EsServicer;
import com.ruoyi.subject.mapper.EsServicerMapper;
import java.math.BigDecimal;

/**
 * 评论管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@Service
public class EsReviewsServiceImpl implements IEsReviewsService 
{
    private static final Logger log = LoggerFactory.getLogger(EsReviewsServiceImpl.class);
    
    @Autowired
    private SQApiClient sqApiClient;

    @Autowired
    private EsReviewsMapper esReviewsMapper;

    @Autowired
    private EsServicerMapper esServicerMapper;

    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    @Override
    public EsReviews selectEsReviewsById(Long id)
    {
        return esReviewsMapper.selectEsReviewsById(id);
    }

    /**
     * 查询评论管理列表
     * 
     * @param esReviews 评论管理
     * @return 评论管理
     */
    @Override
    public List<EsReviews> selectEsReviewsList(EsReviews esReviews)
    {
        return esReviewsMapper.selectEsReviewsList(esReviews);
    }

    /**
     * 新增评论管理
     * 
     * @param esReviews 评论管理
     * @return 结果
     */
    @Override
    public int insertEsReviews(EsReviews esReviews)
    {
        try {
            // 验证服务主体是否存在
            EsServicer servicer = esServicerMapper.selectEsServicerById(esReviews.getServicerId());
            if (servicer == null) {
                log.error("服务主体不存在: servicer_id={}", esReviews.getServicerId());
                throw new RuntimeException("服务主体不存在");
            }
            
            log.info("开始处理评论 - servicer_id: {}, content: {}", 
                    esReviews.getServicerId(), esReviews.getContent());

            // 调用API获取SQdim和SenScore
            SQResponse response = sqApiClient.analyzeReview(esReviews.getContent());
            if (response != null) {
                if (response.getCode() == 0 && response.getData() != null) {
                    Map<String, Object> data = response.getData();
                    // 获取SQdim（0-4）
                    Object sqdim = data.get("SQdim");
                    if (sqdim != null) {
                        esReviews.setSQdim(Long.valueOf(sqdim.toString()));
                    }
                    
                    // 获取SenScore（-1到1）
                    Object senScore = data.get("SenScore");
                    if (senScore != null) {
                        double score = Double.parseDouble(senScore.toString());
                        esReviews.setSenScore(score);
                    }
                } else {
                    log.warn("评论分析API返回异常: code={}, msg={}", response.getCode(), response.getMsg());
                    esReviews.setSQdim(0L);
                    esReviews.setSenScore(0.0);
                }
            } else {
                log.error("评论分析API返回为空");
                esReviews.setSQdim(0L);
                esReviews.setSenScore(0.0);
            }

            // 调用服务主体评分API
            SQResponse businessResponse = sqApiClient.getServiceQuality(esReviews.getServicerId());
            log.info("服务主体评分API响应 - servicer_id: {}, response: {}", 
                    esReviews.getServicerId(), businessResponse);
            
            if (businessResponse != null) {
                if (businessResponse.getCode() == 0 && businessResponse.getData() != null) {
                    Map<String, Object> businessData = businessResponse.getData();
                    updateServicerScores(esReviews.getServicerId(), businessData);
                } else {
                    log.warn("服务主体评分API返回异常 - servicer_id: {}, code: {}, msg: {}", 
                            esReviews.getServicerId(), 
                            businessResponse.getCode(), 
                            businessResponse.getMsg());
                }
            }

            esReviews.setCreateTime(DateUtils.getNowDate());
            return esReviewsMapper.insertEsReviews(esReviews);
        } catch (Exception e) {
            log.error("评论处理失败 - servicer_id: {}, error: {}", 
                    esReviews.getServicerId(), e.getMessage(), e);
            throw new RuntimeException("评论处理失败: " + e.getMessage());
        }
    }

    private void updateServicerScores(Long servicerId, Map<String, Object> scores) {
        try {
            EsServicer servicer = new EsServicer();
            servicer.setId(servicerId);
            
            // 设置各项评分
            if (scores.containsKey("TangiSc")) {
                servicer.setTangiSc(new BigDecimal(scores.get("TangiSc").toString()));
            }
            if (scores.containsKey("ReliSc")) {
                servicer.setReliSc(new BigDecimal(scores.get("ReliSc").toString()));
            }
            if (scores.containsKey("ResponSc")) {
                servicer.setResponSc(new BigDecimal(scores.get("ResponSc").toString()));
            }
            if (scores.containsKey("AssuranceSc")) {
                servicer.setAssuranceSc(new BigDecimal(scores.get("AssuranceSc").toString()));
            }
            if (scores.containsKey("EmpathySc")) {
                servicer.setEmpathySc(new BigDecimal(scores.get("EmpathySc").toString()));
            }
            if (scores.containsKey("TotalSc")) {
                servicer.setTotalSc(new BigDecimal(scores.get("TotalSc").toString()));
            }
            
            esServicerMapper.updateEsServicer(servicer);
        } catch (Exception e) {
            log.error("更新服务主体评分失败", e);
        }
    }

    /**
     * 修改评论管理
     * 
     * @param esReviews 评论管理
     * @return 结果
     */
    @Override
    public int updateEsReviews(EsReviews esReviews)
    {
        esReviews.setUpdateTime(DateUtils.getNowDate());
        return esReviewsMapper.updateEsReviews(esReviews);
    }

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的评论管理主键
     * @return 结果
     */
    @Override
    public int deleteEsReviewsByIds(Long[] ids)
    {
        return esReviewsMapper.deleteEsReviewsByIds(ids);
    }

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    @Override
    public int deleteEsReviewsById(Long id)
    {
        return esReviewsMapper.deleteEsReviewsById(id);
    }
}
