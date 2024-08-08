package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EsAuditProcess;

/**
 * 服务主体审核Mapper接口
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
public interface EsAuditProcessMapper 
{
    /**
     * 查询服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 服务主体审核
     */
    public EsAuditProcess selectEsAuditProcessById(Long id);

    /**
     * 查询服务主体审核列表
     * 
     * @param esAuditProcess 服务主体审核
     * @return 服务主体审核集合
     */
    public List<EsAuditProcess> selectEsAuditProcessList(EsAuditProcess esAuditProcess);

    /**
     * 新增服务主体审核
     * 
     * @param esAuditProcess 服务主体审核
     * @return 结果
     */
    public int insertEsAuditProcess(EsAuditProcess esAuditProcess);

    /**
     * 修改服务主体审核
     * 
     * @param esAuditProcess 服务主体审核
     * @return 结果
     */
    public int updateEsAuditProcess(EsAuditProcess esAuditProcess);

    /**
     * 删除服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 结果
     */
    public int deleteEsAuditProcessById(Long id);

    /**
     * 批量删除服务主体审核
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsAuditProcessByIds(Long[] ids);
}
