package com.ruoyi.base.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.EsStandardsMapper;
import com.ruoyi.base.domain.EsStandards;
import com.ruoyi.base.service.IEsStandardsService;

/**
 * 标准管理Service业务层处理
 * 
 * @author 翁甜甜
 * @date 2025-09-08
 */
@Service
public class EsStandardsServiceImpl implements IEsStandardsService 
{
    @Autowired
    private EsStandardsMapper esStandardsMapper;

    /**
     * 查询标准管理
     * 
     * @param id 标准管理主键
     * @return 标准管理
     */
    @Override
    public EsStandards selectEsStandardsById(Long id)
    {
        return esStandardsMapper.selectEsStandardsById(id);
    }

    /**
     * 查询标准管理列表
     * 
     * @param esStandards 标准管理
     * @return 标准管理
     */
    @Override
    public List<EsStandards> selectEsStandardsList(EsStandards esStandards)
    {
        return esStandardsMapper.selectEsStandardsList(esStandards);
    }

    /**
     * 新增标准管理
     * 
     * @param esStandards 标准管理
     * @return 结果
     */
    @Override
    public int insertEsStandards(EsStandards esStandards)
    {
        esStandards.setCreateTime(DateUtils.getNowDate());
        return esStandardsMapper.insertEsStandards(esStandards);
    }

    /**
     * 修改标准管理
     * 
     * @param esStandards 标准管理
     * @return 结果
     */
    @Override
    public int updateEsStandards(EsStandards esStandards)
    {
        esStandards.setUpdateTime(DateUtils.getNowDate());
        return esStandardsMapper.updateEsStandards(esStandards);
    }

    /**
     * 批量删除标准管理
     * 
     * @param ids 需要删除的标准管理主键
     * @return 结果
     */
    @Override
    public int deleteEsStandardsByIds(Long[] ids)
    {
        return esStandardsMapper.deleteEsStandardsByIds(ids);
    }

    /**
     * 删除标准管理信息
     * 
     * @param id 标准管理主键
     * @return 结果
     */
    @Override
    public int deleteEsStandardsById(Long id)
    {
        return esStandardsMapper.deleteEsStandardsById(id);
    }
}
