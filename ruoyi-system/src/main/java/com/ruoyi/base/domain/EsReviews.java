package com.ruoyi.base.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论管理对象 es_reviews
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
public class EsReviews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评价ID */
    private Long id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 服务主体ID */
    @Excel(name = "服务主体ID")
    private Long servicerId;

    /** 评价内容 */
    @Excel(name = "评价内容")
    private String content;

    /** 五星评分 */
    @Excel(name = "五星评分")
    private Long rating;

    /** 是否删除（0:未删除, 1:已删除） */
    @Excel(name = "是否删除", readConverterExp = "0=:未删除,,1=:已删除")
    private Long isDelete;

    /** 服务质量维度 */
    @Excel(name = "服务质量维度")
    private Long SQdim;

    /** 情感评分 */
    @Excel(name = "情感评分")
    private double SenScore;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setServicerId(Long servicerId) 
    {
        this.servicerId = servicerId;
    }

    public Long getServicerId() 
    {
        return servicerId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setRating(Long rating) 
    {
        this.rating = rating;
    }

    public Long getRating() 
    {
        return rating;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }
    public void setSQdim(Long SQdim) 
    {
        this.SQdim = SQdim;
    }

    public Long getSQdim() 
    {
        return SQdim;
    }
    public void setSenScore(double score) 
    {
        this.SenScore = score;
    }

    public double getSenScore() 
    {
        return SenScore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("servicerId", getServicerId())
            .append("content", getContent())
            .append("rating", getRating())
            .append("isDelete", getIsDelete())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("SQdim", getSQdim())
            .append("SenScore", getSenScore())
            .toString();
    }
}
