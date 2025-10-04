package com.ruoyi.apply.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务主体审核对象 es_servicer_apply
 * 
 * @author ruoyi
 * @date 2025-09-25
 */
public class EsServicerApply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 申请人用户ID */
    @Excel(name = "申请人用户ID")
    private Long applyUserId;

    /** 主体名称 */
    @Excel(name = "主体名称")
    private String name;

    /** 组织类型ID */
    @Excel(name = "组织类型ID")
    private Long typeId;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String accountPhone;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String corporate;

    /** 服务种类详情 */
    @Excel(name = "服务种类详情")
    private String serviceTypeXx;

    /** 服务种类路径 */
    @Excel(name = "服务种类路径")
    private String serviceTypePath;

    /** 省市县区镇 */
    @Excel(name = "省市县区镇")
    private String regionPre;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String regionXx;

    /** 服务区域路径 */
    @Excel(name = "服务区域路径")
    private String regionId;

    /** 主体介绍 */
    @Excel(name = "主体介绍")
    private String introduce;

    /** 主体Logo */
    @Excel(name = "主体Logo")
    private String logo;

    /** 主体视频 */
    @Excel(name = "主体视频")
    private String video;

    /** 营业执照 */
    @Excel(name = "营业执照")
    private String manageCert;

    /** 主体图片URL */
    @Excel(name = "主体图片URL")
    private String pictureUrls;

    /** 从业人数 */
    @Excel(name = "从业人数")
    private Long population;

    /** 年服务营业收入 */
    @Excel(name = "年服务营业收入")
    private BigDecimal income;

    /** 服务对象数 */
    @Excel(name = "服务对象数")
    private Long serveNum;

    /** 服务小农户数 */
    @Excel(name = "服务小农户数")
    private Long farmersNum;

    /** 年服务面积 */
    @Excel(name = "年服务面积")
    private BigDecimal serveArea;

    /** 年畜牧服务量 */
    @Excel(name = "年畜牧服务量")
    private Long raiseNum;

    /** 年水产服务量 */
    @Excel(name = "年水产服务量")
    private Long waterNum;

    /** 其他行业服务总量 */
    @Excel(name = "其他行业服务总量")
    private Long otherNum;

    /** 服务粮食作物面积 */
    @Excel(name = "服务粮食作物面积")
    private BigDecimal cropArea;

    /** 审核状态：0通过，1不通过，2审核中，对应es_sh_jg */
    @Excel(name = "审核状态：0通过，1不通过，2审核中，对应es_sh_jg")
    private Integer auditStatus;

    /** 准入状态：0未准入，1已准入，2审核中，对应es_is_auth */
    @Excel(name = "准入状态：0未准入，1已准入，2审核中，对应es_is_auth")
    private Integer isAuth;

    /** 经营状态：0正常，1异常，对应es_manage_status */
    @Excel(name = "经营状态：0正常，1异常，对应es_manage_status")
    private Integer manageStatus;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditRemark;

    /** 审核人ID */
    @Excel(name = "审核人ID")
    private Long auditUserId;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplyUserId(Long applyUserId) 
    {
        this.applyUserId = applyUserId;
    }

    public Long getApplyUserId() 
    {
        return applyUserId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTypeId(Long typeId) 
    {
        this.typeId = typeId;
    }

    public Long getTypeId() 
    {
        return typeId;
    }
    public void setAccountPhone(String accountPhone) 
    {
        this.accountPhone = accountPhone;
    }

    public String getAccountPhone() 
    {
        return accountPhone;
    }
    public void setCorporate(String corporate) 
    {
        this.corporate = corporate;
    }

    public String getCorporate() 
    {
        return corporate;
    }
    public void setServiceTypeXx(String serviceTypeXx) 
    {
        this.serviceTypeXx = serviceTypeXx;
    }

    public String getServiceTypeXx() 
    {
        return serviceTypeXx;
    }
    public void setServiceTypePath(String serviceTypePath) 
    {
        this.serviceTypePath = serviceTypePath;
    }

    public String getServiceTypePath() 
    {
        return serviceTypePath;
    }
    public void setRegionPre(String regionPre) 
    {
        this.regionPre = regionPre;
    }

    public String getRegionPre() 
    {
        return regionPre;
    }
    public void setRegionXx(String regionXx) 
    {
        this.regionXx = regionXx;
    }

    public String getRegionXx() 
    {
        return regionXx;
    }
    public void setRegionId(String regionId) 
    {
        this.regionId = regionId;
    }

    public String getRegionId() 
    {
        return regionId;
    }
    public void setIntroduce(String introduce) 
    {
        this.introduce = introduce;
    }

    public String getIntroduce() 
    {
        return introduce;
    }
    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }
    public void setVideo(String video) 
    {
        this.video = video;
    }

    public String getVideo() 
    {
        return video;
    }
    public void setManageCert(String manageCert) 
    {
        this.manageCert = manageCert;
    }

    public String getManageCert() 
    {
        return manageCert;
    }
    public void setPictureUrls(String pictureUrls) 
    {
        this.pictureUrls = pictureUrls;
    }

    public String getPictureUrls() 
    {
        return pictureUrls;
    }
    public void setPopulation(Long population) 
    {
        this.population = population;
    }

    public Long getPopulation() 
    {
        return population;
    }
    public void setIncome(BigDecimal income) 
    {
        this.income = income;
    }

    public BigDecimal getIncome() 
    {
        return income;
    }
    public void setServeNum(Long serveNum) 
    {
        this.serveNum = serveNum;
    }

    public Long getServeNum() 
    {
        return serveNum;
    }
    public void setFarmersNum(Long farmersNum) 
    {
        this.farmersNum = farmersNum;
    }

    public Long getFarmersNum() 
    {
        return farmersNum;
    }
    public void setServeArea(BigDecimal serveArea) 
    {
        this.serveArea = serveArea;
    }

    public BigDecimal getServeArea() 
    {
        return serveArea;
    }
    public void setRaiseNum(Long raiseNum) 
    {
        this.raiseNum = raiseNum;
    }

    public Long getRaiseNum() 
    {
        return raiseNum;
    }
    public void setWaterNum(Long waterNum) 
    {
        this.waterNum = waterNum;
    }

    public Long getWaterNum() 
    {
        return waterNum;
    }
    public void setOtherNum(Long otherNum) 
    {
        this.otherNum = otherNum;
    }

    public Long getOtherNum() 
    {
        return otherNum;
    }
    public void setCropArea(BigDecimal cropArea) 
    {
        this.cropArea = cropArea;
    }

    public BigDecimal getCropArea() 
    {
        return cropArea;
    }
    public void setAuditStatus(Integer auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() 
    {
        return auditStatus;
    }
    public void setIsAuth(Integer isAuth) 
    {
        this.isAuth = isAuth;
    }

    public Integer getIsAuth() 
    {
        return isAuth;
    }
    public void setManageStatus(Integer manageStatus) 
    {
        this.manageStatus = manageStatus;
    }

    public Integer getManageStatus() 
    {
        return manageStatus;
    }
    public void setAuditRemark(String auditRemark) 
    {
        this.auditRemark = auditRemark;
    }

    public String getAuditRemark() 
    {
        return auditRemark;
    }
    public void setAuditUserId(Long auditUserId) 
    {
        this.auditUserId = auditUserId;
    }

    public Long getAuditUserId() 
    {
        return auditUserId;
    }
    public void setAuditTime(Date auditTime) 
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime() 
    {
        return auditTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applyUserId", getApplyUserId())
            .append("name", getName())
            .append("typeId", getTypeId())
            .append("accountPhone", getAccountPhone())
            .append("corporate", getCorporate())
            .append("serviceTypeXx", getServiceTypeXx())
            .append("serviceTypePath", getServiceTypePath())
            .append("regionPre", getRegionPre())
            .append("regionXx", getRegionXx())
            .append("regionId", getRegionId())
            .append("introduce", getIntroduce())
            .append("logo", getLogo())
            .append("video", getVideo())
            .append("manageCert", getManageCert())
            .append("pictureUrls", getPictureUrls())
            .append("population", getPopulation())
            .append("income", getIncome())
            .append("serveNum", getServeNum())
            .append("farmersNum", getFarmersNum())
            .append("serveArea", getServeArea())
            .append("raiseNum", getRaiseNum())
            .append("waterNum", getWaterNum())
            .append("otherNum", getOtherNum())
            .append("cropArea", getCropArea())
            .append("auditStatus", getAuditStatus())
            .append("isAuth", getIsAuth())
            .append("manageStatus", getManageStatus())
            .append("auditRemark", getAuditRemark())
            .append("auditUserId", getAuditUserId())
            .append("auditTime", getAuditTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
