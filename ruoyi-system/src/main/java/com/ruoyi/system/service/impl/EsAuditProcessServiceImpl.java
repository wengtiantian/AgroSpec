package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EsAuditProcessMapper;
import com.ruoyi.system.domain.EsAuditProcess;
import com.ruoyi.system.service.IEsAuditProcessService;

/**
 * 服务主体审核Service业务层处理
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
@Service
public class EsAuditProcessServiceImpl implements IEsAuditProcessService 
{
    @Autowired
    private EsAuditProcessMapper esAuditProcessMapper;

    /**
     * 查询服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 服务主体审核
     */
    @Override
    public EsAuditProcess selectEsAuditProcessById(Long id)
    {
        return esAuditProcessMapper.selectEsAuditProcessById(id);
    }

    /**
     * 查询服务主体审核列表
     * 
     * @param esAuditProcess 服务主体审核
     * @return 服务主体审核
     */
    @Override
    public List<EsAuditProcess> selectEsAuditProcessList(EsAuditProcess esAuditProcess)
    {
        return esAuditProcessMapper.selectEsAuditProcessList(esAuditProcess);
    }

    /**
     * 新增服务主体审核
     * 
     * @param esAuditProcess 服务主体审核
     * @return 结果
     */
    @Override
    public int insertEsAuditProcess(EsAuditProcess esAuditProcess)
    {
        esAuditProcess.setCreateTime(DateUtils.getNowDate());
        return esAuditProcessMapper.insertEsAuditProcess(esAuditProcess);
    }

    /**
     * 修改服务主体审核
     * 
     * @param esAuditProcess 服务主体审核
     * @return 结果
     */
    @Override
    public int updateEsAuditProcess(EsAuditProcess esAuditProcess)
    {
        esAuditProcess.setUpdateTime(DateUtils.getNowDate());
        return esAuditProcessMapper.updateEsAuditProcess(esAuditProcess);
    }

    /**
     * 批量删除服务主体审核
     * 
     * @param ids 需要删除的服务主体审核主键
     * @return 结果
     */
    @Override
    public int deleteEsAuditProcessByIds(Long[] ids)
    {
        return esAuditProcessMapper.deleteEsAuditProcessByIds(ids);
    }

    /**
     * 删除服务主体审核信息
     * 
     * @param id 服务主体审核主键
     * @return 结果
     */
    @Override
    public int deleteEsAuditProcessById(Long id)
    {
        return esAuditProcessMapper.deleteEsAuditProcessById(id);
    }
}
