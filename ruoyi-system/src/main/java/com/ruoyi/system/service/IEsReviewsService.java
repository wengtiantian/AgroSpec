package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.EsReviews;

/**
 * 评价Service接口
 * 
 * @author ruoyi
 * @date 2025-01-15
 */
public interface IEsReviewsService 
{
    /**
     * 查询评价
     * 
     * @param id 评价主键
     * @return 评价
     */
    public EsReviews selectEsReviewsById(Long id);

    /**
     * 查询评价列表
     * 
     * @param esReviews 评价
     * @return 评价集合
     */
    public List<EsReviews> selectEsReviewsList(EsReviews esReviews);

    /**
     * 新增评价
     * 
     * @param esReviews 评价
     * @return 结果
     */
    public int insertEsReviews(EsReviews esReviews);

    /**
     * 修改评价
     * 
     * @param esReviews 评价
     * @return 结果
     */
    public int updateEsReviews(EsReviews esReviews);

    /**
     * 批量删除评价
     * 
     * @param ids 需要删除的评价主键集合
     * @return 结果
     */
    public int deleteEsReviewsByIds(Long[] ids);

    /**
     * 删除评价信息
     * 
     * @param id 评价主键
     * @return 结果
     */
    public int deleteEsReviewsById(Long id);
}
