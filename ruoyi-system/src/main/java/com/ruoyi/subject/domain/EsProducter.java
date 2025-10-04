package com.ruoyi.subject.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生产主体管理对象 es_producter
 * 
 * @author wangchuang
 * @date 2024-07-14
 */
public class EsProducter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 服务主体id */
    private Long id;

    /** 用户 */
    private Long userId;

    /** 组织类型ID，外键关联到类型表 */
    @Excel(name = "组织类型ID，外键关联到类型表")
    private Long typeId;

    /** 生产主体名称 */
    @Excel(name = "生产主体名称")
    private String name;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String accountPhone;

    /** 身份证号码 */
    @Excel(name = "身份证号码")
    private String idNumber;

    /** 土地确权证号 */
    @Excel(name = "土地确权证号")
    private String soilNum;

    /** 土地确权证书图片路径 */
    @Excel(name = "土地确权证书图片路径")
    private String soilpic;

    /** 承包合同图片路径 */
    @Excel(name = "承包合同图片路径")
    private String contract;

    /** 营业执照图片路径 */
    @Excel(name = "营业执照图片路径")
    private String businessLicense;

    /** 地区 */
    @Excel(name = "地区")
    private Long regionId;

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
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAccountPhone(String accountPhone) 
    {
        this.accountPhone = accountPhone;
    }

    public String getAccountPhone() 
    {
        return accountPhone;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setSoilNum(String soilNum) 
    {
        this.soilNum = soilNum;
    }

    public String getSoilNum() 
    {
        return soilNum;
    }
    public void setSoilpic(String soilpic) 
    {
        this.soilpic = soilpic;
    }

    public String getSoilpic() 
    {
        return soilpic;
    }
    public void setContract(String contract) 
    {
        this.contract = contract;
    }

    public String getContract() 
    {
        return contract;
    }
    public void setBusinessLicense(String businessLicense) 
    {
        this.businessLicense = businessLicense;
    }

    public String getBusinessLicense() 
    {
        return businessLicense;
    }
    public void setRegionId(Long regionId) 
    {
        this.regionId = regionId;
    }

    public Long getRegionId() 
    {
        return regionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("typeId", getTypeId())
            .append("name", getName())
            .append("accountPhone", getAccountPhone())
            .append("idNumber", getIdNumber())
            .append("soilNum", getSoilNum())
            .append("soilpic", getSoilpic())
            .append("contract", getContract())
            .append("businessLicense", getBusinessLicense())
            .append("regionId", getRegionId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
