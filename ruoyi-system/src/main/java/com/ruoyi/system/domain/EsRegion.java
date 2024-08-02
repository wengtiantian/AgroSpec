package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 地区(es_regions)对象 es_region
 * 
 * @author 王创
 * @date 2024-06-20
 */
public class EsRegion extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 地区id */
    private Long id;

    /** 路径 */
    @Excel(name = "路径")
    private String regionPath;

    /** 级别 */
    @Excel(name = "级别")
    private Integer regionGrade;

    /** 名称 */
    @Excel(name = "名称")
    private String localName;

    /** 邮编 */
    @Excel(name = "邮编")
    private String zipcode;

    /** 是否支持货到付款 */
    @Excel(name = "是否支持货到付款")
    private String cod;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRegionPath(String regionPath) 
    {
        this.regionPath = regionPath;
    }

    public String getRegionPath() 
    {
        return regionPath;
    }
    public void setRegionGrade(Integer regionGrade) 
    {
        this.regionGrade = regionGrade;
    }

    public Integer getRegionGrade() 
    {
        return regionGrade;
    }
    public void setLocalName(String localName) 
    {
        this.localName = localName;
    }

    public String getLocalName() 
    {
        return localName;
    }
    public void setZipcode(String zipcode) 
    {
        this.zipcode = zipcode;
    }

    public String getZipcode() 
    {
        return zipcode;
    }
    public void setCod(String cod) 
    {
        this.cod = cod;
    }

    public String getCod() 
    {
        return cod;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("regionPath", getRegionPath())
            .append("regionGrade", getRegionGrade())
            .append("localName", getLocalName())
            .append("zipcode", getZipcode())
            .append("cod", getCod())
            .toString();
    }
}
