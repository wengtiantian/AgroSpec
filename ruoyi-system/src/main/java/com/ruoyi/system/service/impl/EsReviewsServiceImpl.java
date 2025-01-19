package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EsReviewsMapper;
import com.ruoyi.system.domain.EsReviews;
import com.ruoyi.system.service.IEsReviewsService;

/**
 * 评价Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-15
 */
@Service
public class EsReviewsServiceImpl implements IEsReviewsService 
{
    @Autowired
    private EsReviewsMapper esReviewsMapper;

    /**
     * 查询评价
     * 
     * @param id 评价主键
     * @return 评价
     */
    @Override
    public EsReviews selectEsReviewsById(Long id)
    {
        return esReviewsMapper.selectEsReviewsById(id);
    }

    /**
     * 查询评价列表
     * 
     * @param esReviews 评价
     * @return 评价
     */
    @Override
    public List<EsReviews> selectEsReviewsList(EsReviews esReviews)
    {
        return esReviewsMapper.selectEsReviewsList(esReviews);
    }

    /**
     * 新增评价
     * 
     * @param esReviews 评价
     * @return 结果
     */
    @Override
    public int insertEsReviews(EsReviews esReviews)
    {
        esReviews.setCreateTime(DateUtils.getNowDate());
        return esReviewsMapper.insertEsReviews(esReviews);
    }

    /**
     * 修改评价
     * 
     * @param esReviews 评价
     * @return 结果
     */
    @Override
    public int updateEsReviews(EsReviews esReviews)
    {
        esReviews.setUpdateTime(DateUtils.getNowDate());
        return esReviewsMapper.updateEsReviews(esReviews);
    }

    /**
     * 批量删除评价
     * 
     * @param ids 需要删除的评价主键
     * @return 结果
     */
    @Override
    public int deleteEsReviewsByIds(Long[] ids)
    {
        return esReviewsMapper.deleteEsReviewsByIds(ids);
    }

    /**
     * 删除评价信息
     * 
     * @param id 评价主键
     * @return 结果
     */
    @Override
    public int deleteEsReviewsById(Long id)
    {
        return esReviewsMapper.deleteEsReviewsById(id);
    }
}
