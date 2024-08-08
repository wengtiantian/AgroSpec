package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务主体审核对象 es_audit_process
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
public class EsAuditProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审核流程ID */
    private Long id;

    /** 服务主体ID */
    @Excel(name = "服务主体ID")
    private Long servicerId;

    /** 审核内容 */
    @Excel(name = "审核内容")
    private String auditContent;

    /** 审核结果 */
    @Excel(name = "审核结果")
    private Long auditResult;

    /** 评语 */
    @Excel(name = "评语")
    private String comments;

    /** 审核人 */
    @Excel(name = "审核人")
    private Long auditorId;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 软删除标识时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "软删除标识时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deletedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setServicerId(Long servicerId) 
    {
        this.servicerId = servicerId;
    }

    public Long getServicerId() 
    {
        return servicerId;
    }
    public void setAuditContent(String auditContent) 
    {
        this.auditContent = auditContent;
    }

    public String getAuditContent() 
    {
        return auditContent;
    }
    public void setAuditResult(Long auditResult) 
    {
        this.auditResult = auditResult;
    }

    public Long getAuditResult() 
    {
        return auditResult;
    }
    public void setComments(String comments) 
    {
        this.comments = comments;
    }

    public String getComments() 
    {
        return comments;
    }
    public void setAuditorId(Long auditorId) 
    {
        this.auditorId = auditorId;
    }

    public Long getAuditorId() 
    {
        return auditorId;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }
    public void setDeletedAt(Date deletedAt) 
    {
        this.deletedAt = deletedAt;
    }

    public Date getDeletedAt() 
    {
        return deletedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("servicerId", getServicerId())
            .append("auditContent", getAuditContent())
            .append("auditResult", getAuditResult())
            .append("comments", getComments())
            .append("auditorId", getAuditorId())
            .append("auditTime", getAuditTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deletedAt", getDeletedAt())
            .toString();
    }
}
