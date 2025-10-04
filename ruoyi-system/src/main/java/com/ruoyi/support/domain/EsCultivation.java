package com.ruoyi.support.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 种植标准管理对象 es_cultivation
 * 
 * @author ruoyi
 * @date 2025-05-07
 */
public class EsCultivation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 标准编号 */
    @Excel(name = "标准编号")
    private String standardId;

    /** 标准名称 */
    @Excel(name = "标准名称")
    private String standardName;

    /** 发布单位 */
    @Excel(name = "发布单位")
    private String companyName;

    /** 发布日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishDate;

    /** 实施日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实施日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date impleDate;

    /** 起草人 */
    @Excel(name = "起草人")
    private String author;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String fileUrl;

    /** 省份地区 */
    @Excel(name = "省份地区")
    private String province;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStandardId(String standardId) 
    {
        this.standardId = standardId;
    }

    public String getStandardId() 
    {
        return standardId;
    }
    public void setStandardName(String standardName) 
    {
        this.standardName = standardName;
    }

    public String getStandardName() 
    {
        return standardName;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setPublishDate(Date publishDate) 
    {
        this.publishDate = publishDate;
    }

    public Date getPublishDate() 
    {
        return publishDate;
    }
    public void setImpleDate(Date impleDate) 
    {
        this.impleDate = impleDate;
    }

    public Date getImpleDate() 
    {
        return impleDate;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("standardId", getStandardId())
            .append("standardName", getStandardName())
            .append("companyName", getCompanyName())
            .append("publishDate", getPublishDate())
            .append("impleDate", getImpleDate())
            .append("author", getAuthor())
            .append("fileUrl", getFileUrl())
            .append("province", getProvince())
            .toString();
    }
}
