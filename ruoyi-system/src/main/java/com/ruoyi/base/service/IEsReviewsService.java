package com.ruoyi.base.service;

import java.util.List;
import com.ruoyi.base.domain.EsReviews;

/**
 * 评论管理Service接口
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public interface IEsReviewsService 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    public EsReviews selectEsReviewsById(Long id);

    /**
     * 查询评论管理列表
     * 
     * @param esReviews 评论管理
     * @return 评论管理集合
     */
    public List<EsReviews> selectEsReviewsList(EsReviews esReviews);

    /**
     * 新增评论管理
     * 
     * @param esReviews 评论管理
     * @return 结果
     */
    public int insertEsReviews(EsReviews esReviews);

    /**
     * 修改评论管理
     * 
     * @param esReviews 评论管理
     * @return 结果
     */
    public int updateEsReviews(EsReviews esReviews);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的评论管理主键集合
     * @return 结果
     */
    public int deleteEsReviewsByIds(Long[] ids);

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    public int deleteEsReviewsById(Long id);
}
