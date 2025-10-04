package com.ruoyi.support.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 农机对象 es_machinery
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
public class EsMachinery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 农机ID */
    private Long id;

    /** 服务主体ID */
    @Excel(name = "服务主体ID")
    private Long serviceSubjectId;

    /** 农机名称 */
    @Excel(name = "农机名称")
    private String machineName;

    /** 农机型号 */
    @Excel(name = "农机型号")
    private String machineModel;

    /** 终端编号 */
    @Excel(name = "终端编号")
    private String terminalNumber;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String manufacturer;

    /** 农机图片 */
    @Excel(name = "农机图片")
    private String machineImageUrl;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setServiceSubjectId(Long serviceSubjectId) 
    {
        this.serviceSubjectId = serviceSubjectId;
    }

    public Long getServiceSubjectId() 
    {
        return serviceSubjectId;
    }
    public void setMachineName(String machineName) 
    {
        this.machineName = machineName;
    }

    public String getMachineName() 
    {
        return machineName;
    }
    public void setMachineModel(String machineModel) 
    {
        this.machineModel = machineModel;
    }

    public String getMachineModel() 
    {
        return machineModel;
    }
    public void setTerminalNumber(String terminalNumber) 
    {
        this.terminalNumber = terminalNumber;
    }

    public String getTerminalNumber() 
    {
        return terminalNumber;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setMachineImageUrl(String machineImageUrl) 
    {
        this.machineImageUrl = machineImageUrl;
    }

    public String getMachineImageUrl() 
    {
        return machineImageUrl;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serviceSubjectId", getServiceSubjectId())
            .append("machineName", getMachineName())
            .append("machineModel", getMachineModel())
            .append("terminalNumber", getTerminalNumber())
            .append("manufacturer", getManufacturer())
            .append("machineImageUrl", getMachineImageUrl())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
