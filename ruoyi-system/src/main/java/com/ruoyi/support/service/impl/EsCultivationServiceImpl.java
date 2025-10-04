package com.ruoyi.support.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.support.mapper.EsCultivationMapper;
import com.ruoyi.support.domain.EsCultivation;
import com.ruoyi.support.service.IEsCultivationService;

/**
 * 种植标准管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-07
 */
@Service
public class EsCultivationServiceImpl implements IEsCultivationService 
{
    @Autowired
    private EsCultivationMapper esCultivationMapper;

    /**
     * 查询种植标准管理
     * 
     * @param id 种植标准管理主键
     * @return 种植标准管理
     */
    @Override
    public EsCultivation selectEsCultivationById(Long id)
    {
        return esCultivationMapper.selectEsCultivationById(id);
    }

    /**
     * 查询种植标准管理列表
     * 
     * @param esCultivation 种植标准管理
     * @return 种植标准管理
     */
    @Override
    public List<EsCultivation> selectEsCultivationList(EsCultivation esCultivation)
    {
        return esCultivationMapper.selectEsCultivationList(esCultivation);
    }

    /**
     * 新增种植标准管理
     * 
     * @param esCultivation 种植标准管理
     * @return 结果
     */
    @Override
    public int insertEsCultivation(EsCultivation esCultivation)
    {
        return esCultivationMapper.insertEsCultivation(esCultivation);
    }

    /**
     * 修改种植标准管理
     * 
     * @param esCultivation 种植标准管理
     * @return 结果
     */
    @Override
    public int updateEsCultivation(EsCultivation esCultivation)
    {
        return esCultivationMapper.updateEsCultivation(esCultivation);
    }

    /**
     * 批量删除种植标准管理
     * 
     * @param ids 需要删除的种植标准管理主键
     * @return 结果
     */
    @Override
    public int deleteEsCultivationByIds(Long[] ids)
    {
        return esCultivationMapper.deleteEsCultivationByIds(ids);
    }

    /**
     * 删除种植标准管理信息
     * 
     * @param id 种植标准管理主键
     * @return 结果
     */
    @Override
    public int deleteEsCultivationById(Long id)
    {
        return esCultivationMapper.deleteEsCultivationById(id);
    }
}
