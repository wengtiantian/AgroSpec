package com.ruoyi.base.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标准管理对象 es_standards
 * 
 * @author 翁甜甜
 * @date 2025-09-08
 */
public class EsStandards extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一标识符 */
    private Long id;

    /** 标准文件的名称 */
    @Excel(name = "标准文件的名称")
    private String fileName;

    /** 标准文件的唯一编号 */
    @Excel(name = "标准文件的唯一编号")
    private String fileNumber;

    /** 发布该标准文件的机构名称 */
    @Excel(name = "发布该标准文件的机构名称")
    private String issuingAgency;

    /** 起草人 */
    @Excel(name = "起草人")
    private String author;

    /** 文件的发布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文件的发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date issueDate;

    /** 文件开始实施的日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文件开始实施的日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date effectiveDate;

    /** 文件所属的标准类别（技术标准、管理标准和工作标准），对应字典表 sys_dict_data 的 dict_value */
    @Excel(name = "文件所属的标准类别", readConverterExp = "技=术标准、管理标准和工作标准")
    private String standardCategory;

    /** 文件所属标准类别下的领域（养殖、种植、加工、检验），对应字典表 sys_dict_data 的 dict_value */
    @Excel(name = "文件所属标准类别下的领域", readConverterExp = "养=殖、种植、加工、检验")
    private String standardDomain;

    /** 文件适用的农业服务范围 */
    @Excel(name = "文件适用的农业服务范围")
    private String serviceScope;

    /** 具体的服务项目或内容 */
    @Excel(name = "具体的服务项目或内容")
    private String serviceItems;

    /** 服务的具体要求和规范 */
    @Excel(name = "服务的具体要求和规范")
    private String serviceRequirements;

    /** 技术标准和参数 */
    @Excel(name = "技术标准和参数")
    private String technicalParameters;

    /** 服务质量的评估指标 */
    @Excel(name = "服务质量的评估指标")
    private String qualityIndicators;

    /** 文件的版本号 */
    @Excel(name = "文件的版本号")
    private String versionNumber;

    /** 文件修订的日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文件修订的日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date revisionDate;

    /** 修订内容的简要说明 */
    @Excel(name = "修订内容的简要说明")
    private String revisionNotes;

    /** 相关或引用的其他标准文件 */
    @Excel(name = "相关或引用的其他标准文件")
    private String relatedFiles;

    /** 标准文件的封面图片 */
    @Excel(name = "标准文件的封面图片")
    private String coverImage;

    /** 其他附加资料或附件 */
    @Excel(name = "其他附加资料或附件")
    private String attachments;

    /** 任何其他需要说明的信息 */
    @Excel(name = "任何其他需要说明的信息")
    private String notes;

    /** 0.未删除，1.删除 */
    @Excel(name = "0.未删除，1.删除")
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFileNumber(String fileNumber) 
    {
        this.fileNumber = fileNumber;
    }

    public String getFileNumber() 
    {
        return fileNumber;
    }
    public void setIssuingAgency(String issuingAgency) 
    {
        this.issuingAgency = issuingAgency;
    }

    public String getIssuingAgency() 
    {
        return issuingAgency;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setIssueDate(Date issueDate) 
    {
        this.issueDate = issueDate;
    }

    public Date getIssueDate() 
    {
        return issueDate;
    }
    public void setEffectiveDate(Date effectiveDate) 
    {
        this.effectiveDate = effectiveDate;
    }

    public Date getEffectiveDate() 
    {
        return effectiveDate;
    }
    public void setStandardCategory(String standardCategory) 
    {
        this.standardCategory = standardCategory;
    }

    public String getStandardCategory() 
    {
        return standardCategory;
    }
    public void setStandardDomain(String standardDomain) 
    {
        this.standardDomain = standardDomain;
    }

    public String getStandardDomain() 
    {
        return standardDomain;
    }
    public void setServiceScope(String serviceScope) 
    {
        this.serviceScope = serviceScope;
    }

    public String getServiceScope() 
    {
        return serviceScope;
    }
    public void setServiceItems(String serviceItems) 
    {
        this.serviceItems = serviceItems;
    }

    public String getServiceItems() 
    {
        return serviceItems;
    }
    public void setServiceRequirements(String serviceRequirements) 
    {
        this.serviceRequirements = serviceRequirements;
    }

    public String getServiceRequirements() 
    {
        return serviceRequirements;
    }
    public void setTechnicalParameters(String technicalParameters) 
    {
        this.technicalParameters = technicalParameters;
    }

    public String getTechnicalParameters() 
    {
        return technicalParameters;
    }
    public void setQualityIndicators(String qualityIndicators) 
    {
        this.qualityIndicators = qualityIndicators;
    }

    public String getQualityIndicators() 
    {
        return qualityIndicators;
    }
    public void setVersionNumber(String versionNumber) 
    {
        this.versionNumber = versionNumber;
    }

    public String getVersionNumber() 
    {
        return versionNumber;
    }
    public void setRevisionDate(Date revisionDate) 
    {
        this.revisionDate = revisionDate;
    }

    public Date getRevisionDate() 
    {
        return revisionDate;
    }
    public void setRevisionNotes(String revisionNotes) 
    {
        this.revisionNotes = revisionNotes;
    }

    public String getRevisionNotes() 
    {
        return revisionNotes;
    }
    public void setRelatedFiles(String relatedFiles) 
    {
        this.relatedFiles = relatedFiles;
    }

    public String getRelatedFiles() 
    {
        return relatedFiles;
    }
    public void setCoverImage(String coverImage) 
    {
        this.coverImage = coverImage;
    }

    public String getCoverImage() 
    {
        return coverImage;
    }
    public void setAttachments(String attachments) 
    {
        this.attachments = attachments;
    }

    public String getAttachments() 
    {
        return attachments;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("fileNumber", getFileNumber())
            .append("issuingAgency", getIssuingAgency())
            .append("author", getAuthor())
            .append("issueDate", getIssueDate())
            .append("effectiveDate", getEffectiveDate())
            .append("standardCategory", getStandardCategory())
            .append("standardDomain", getStandardDomain())
            .append("serviceScope", getServiceScope())
            .append("serviceItems", getServiceItems())
            .append("serviceRequirements", getServiceRequirements())
            .append("technicalParameters", getTechnicalParameters())
            .append("qualityIndicators", getQualityIndicators())
            .append("versionNumber", getVersionNumber())
            .append("revisionDate", getRevisionDate())
            .append("revisionNotes", getRevisionNotes())
            .append("relatedFiles", getRelatedFiles())
            .append("coverImage", getCoverImage())
            .append("attachments", getAttachments())
            .append("notes", getNotes())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
