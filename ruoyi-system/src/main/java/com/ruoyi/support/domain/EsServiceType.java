package com.ruoyi.support.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 服务类型管理对象 es_service_type
 * 
 * @author wangchuang
 * @date 2024-08-01
 */
public class EsServiceType extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 类型id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 图标路径 */
    @Excel(name = "图标路径")
    private String icon;

    /** 父级ID */
    @Excel(name = "父级ID")
    private Long pid;

    /** 排序字段，用于控制显示顺序 */
    @Excel(name = "排序字段，用于控制显示顺序")
    private Long sorting;

    /** 描述或说明 */
    @Excel(name = "描述或说明")
    private String description;

    /** 是否启用，0表示禁用，1表示启用 */
    @Excel(name = "是否启用，0表示禁用，1表示启用")
    private Integer isActive;

    /** 类型路径1,2,3 */
    @Excel(name = "类型路径1,2,3")
    private String typePath;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setSorting(Long sorting) 
    {
        this.sorting = sorting;
    }

    public Long getSorting() 
    {
        return sorting;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setIsActive(Integer isActive) 
    {
        this.isActive = isActive;
    }

    public Integer getIsActive() 
    {
        return isActive;
    }
    public void setTypePath(String typePath) 
    {
        this.typePath = typePath;
    }

    public String getTypePath() 
    {
        return typePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("icon", getIcon())
            .append("pid", getPid())
            .append("sorting", getSorting())
            .append("description", getDescription())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isActive", getIsActive())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("typePath", getTypePath())
            .toString();
    }
}
