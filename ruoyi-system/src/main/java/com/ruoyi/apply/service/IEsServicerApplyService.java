package com.ruoyi.apply.service;

import java.util.List;
import com.ruoyi.apply.domain.EsServicerApply;

/**
 * 服务主体审核Service接口
 * 
 * @author ruoyi
 * @date 2025-09-25
 */
public interface IEsServicerApplyService 
{
    /**
     * 查询服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 服务主体审核
     */
    public EsServicerApply selectEsServicerApplyById(Long id);

    /**
     * 查询服务主体审核列表
     * 
     * @param esServicerApply 服务主体审核
     * @return 服务主体审核集合
     */
    public List<EsServicerApply> selectEsServicerApplyList(EsServicerApply esServicerApply);

    /**
     * 新增服务主体审核
     * 
     * @param esServicerApply 服务主体审核
     * @return 结果
     */
    public int insertEsServicerApply(EsServicerApply esServicerApply);

    /**
     * 修改服务主体审核
     * 
     * @param esServicerApply 服务主体审核
     * @return 结果
     */
    public int updateEsServicerApply(EsServicerApply esServicerApply);

    /**
     * 批量删除服务主体审核
     * 
     * @param ids 需要删除的服务主体审核主键集合
     * @return 结果
     */
    public int deleteEsServicerApplyByIds(Long[] ids);

    /**
     * 删除服务主体审核信息
     * 
     * @param id 服务主体审核主键
     * @return 结果
     */
    public int deleteEsServicerApplyById(Long id);

    /**
     * 审核通过：插入主体并更新申请状态
     */
    public int approveServicerApply(Long applyId, Long auditorUserId);

    /**
     * 审核驳回：更新申请状态与备注
     */
    public int rejectServicerApply(Long applyId, Long auditorUserId, String remark);

    /**
     * 校验是否可以编辑：申请人本人或管理员可编辑
     */
    public boolean canEdit(Long applyId, Long currentUserId);
}
