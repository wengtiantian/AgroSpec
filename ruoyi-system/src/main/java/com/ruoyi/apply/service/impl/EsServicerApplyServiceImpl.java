package com.ruoyi.apply.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.apply.mapper.EsServicerApplyMapper;
import com.ruoyi.apply.domain.EsServicerApply;
import com.ruoyi.apply.service.IEsServicerApplyService;
import com.ruoyi.subject.mapper.EsServicerMapper;
import com.ruoyi.subject.domain.EsServicer;
import com.ruoyi.common.utils.SecurityUtils;

/**
 * 服务主体审核Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-25
 */
@Service
public class EsServicerApplyServiceImpl implements IEsServicerApplyService 
{
    @Autowired
    private EsServicerApplyMapper esServicerApplyMapper;

    @Autowired
    private EsServicerMapper esServicerMapper;

    /**
     * 查询服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 服务主体审核
     */
    @Override
    public EsServicerApply selectEsServicerApplyById(Long id)
    {
        return esServicerApplyMapper.selectEsServicerApplyById(id);
    }

    /**
     * 查询服务主体审核列表
     * 
     * @param esServicerApply 服务主体审核
     * @return 服务主体审核
     */
    @Override
    public List<EsServicerApply> selectEsServicerApplyList(EsServicerApply esServicerApply)
    {
        return esServicerApplyMapper.selectEsServicerApplyList(esServicerApply);
    }

    /**
     * 新增服务主体审核
     * 
     * @param esServicerApply 服务主体审核
     * @return 结果
     */
    @Override
    public int insertEsServicerApply(EsServicerApply esServicerApply)
    {
        esServicerApply.setCreateTime(DateUtils.getNowDate());
        // 默认审核中/准入审核中
        if (esServicerApply.getIsAuth() == null) {
            esServicerApply.setIsAuth(2);
        }
        if (esServicerApply.getAuditStatus() == null) {
            esServicerApply.setAuditStatus(2);
        }
        return esServicerApplyMapper.insertEsServicerApply(esServicerApply);
    }

    /**
     * 修改服务主体审核
     * 
     * @param esServicerApply 服务主体审核
     * @return 结果
     */
    @Override
    public int updateEsServicerApply(EsServicerApply esServicerApply)
    {
        esServicerApply.setUpdateTime(DateUtils.getNowDate());
        return esServicerApplyMapper.updateEsServicerApply(esServicerApply);
    }

    /**
     * 批量删除服务主体审核
     * 
     * @param ids 需要删除的服务主体审核主键
     * @return 结果
     */
    @Override
    public int deleteEsServicerApplyByIds(Long[] ids)
    {
        return esServicerApplyMapper.deleteEsServicerApplyByIds(ids);
    }

    /**
     * 删除服务主体审核信息
     * 
     * @param id 服务主体审核主键
     * @return 结果
     */
    @Override
    public int deleteEsServicerApplyById(Long id)
    {
        return esServicerApplyMapper.deleteEsServicerApplyById(id);
    }

    /**
     * 审核通过：插入主体并更新申请状态
     */
    @Override
    @Transactional
    public int approveServicerApply(Long applyId, Long auditorUserId)
    {
        EsServicerApply apply = esServicerApplyMapper.selectEsServicerApplyById(applyId);
        if (apply == null) {
            return 0;
        }
        // 构造主体数据
        EsServicer servicer = new EsServicer();
        servicer.setUserId(apply.getApplyUserId());
        servicer.setName(apply.getName());
        servicer.setTypeId(apply.getTypeId() == null ? null : apply.getTypeId().longValue());
        servicer.setAccountPhone(apply.getAccountPhone());
        servicer.setCorporate(apply.getCorporate());
        servicer.setServiceTypeXx(apply.getServiceTypeXx());
        servicer.setServiceTypePath(apply.getServiceTypePath());
        servicer.setRegionPre(apply.getRegionPre());
        servicer.setRegionXx(apply.getRegionXx());
        servicer.setRegionId(apply.getRegionId());
        servicer.setIntroduce(apply.getIntroduce());
        servicer.setLogo(apply.getLogo());
        servicer.setVideo(apply.getVideo());
        servicer.setManageCert(apply.getManageCert());
        servicer.setPictureUrls(apply.getPictureUrls());
        servicer.setPopulation(apply.getPopulation() == null ? null : apply.getPopulation().longValue());
        servicer.setIncome(apply.getIncome());
        servicer.setServeNum(apply.getServeNum() == null ? null : apply.getServeNum().longValue());
        servicer.setFarmersNum(apply.getFarmersNum() == null ? null : apply.getFarmersNum().longValue());
        servicer.setServeArea(apply.getServeArea());
        servicer.setRaiseNum(apply.getRaiseNum() == null ? null : apply.getRaiseNum().longValue());
        servicer.setWaterNum(apply.getWaterNum() == null ? null : apply.getWaterNum().longValue());
        servicer.setOtherNum(apply.getOtherNum() == null ? null : apply.getOtherNum().longValue());
        servicer.setCropArea(apply.getCropArea());
        // 通过后主体置已认证（与你们字典一致：2=已认证/1=正常）
        servicer.setIsAuth(2);
        esServicerMapper.insertEsServicer(servicer);

        // 更新申请状态：is_auth=1(已准入)，audit_status=0(通过)
        EsServicerApply update = new EsServicerApply();
        update.setId(applyId);
        update.setIsAuth(1);
        update.setAuditStatus(0);
        update.setAuditUserId(auditorUserId);
        update.setAuditTime(DateUtils.getNowDate());
        return esServicerApplyMapper.updateEsServicerApply(update);
    }

    /**
     * 审核驳回：更新申请状态与备注
     */
    @Override
    @Transactional
    public int rejectServicerApply(Long applyId, Long auditorUserId, String remark)
    {
        EsServicerApply update = new EsServicerApply();
        update.setId(applyId);
        update.setIsAuth(0);
        update.setAuditStatus(1);
        update.setAuditRemark(remark);
        update.setAuditUserId(auditorUserId);
        update.setAuditTime(DateUtils.getNowDate());
        return esServicerApplyMapper.updateEsServicerApply(update);
    }

    @Override
    public boolean canEdit(Long applyId, Long currentUserId)
    {
        if (applyId == null || currentUserId == null) {
            return false;
        }
        EsServicerApply apply = esServicerApplyMapper.selectEsServicerApplyById(applyId);
        if (apply == null) {
            return false;
        }
        // 申请人本人可编辑
        if (currentUserId.equals(apply.getApplyUserId())) {
            return true;
        }
        // 管理员可编辑
        return SecurityUtils.isAdmin(currentUserId);
    }
}
