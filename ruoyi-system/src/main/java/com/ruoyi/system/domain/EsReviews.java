package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评价对象 es_reviews
 * 
 * @author ruoyi
 * @date 2025-01-15
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

    /** 评分（1-5星） */
    @Excel(name = "评分", readConverterExp = "1=-5星")
    private Integer rating;

    /** 是否删除（0:未删除, 1:已删除） */
    @Excel(name = "是否删除", readConverterExp = "0=:未删除,,1=:已删除")
    private Integer isDelete;

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
    public void setRating(Integer rating) 
    {
        this.rating = rating;
    }

    public Integer getRating() 
    {
        return rating;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
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
            .toString();
    }
}
