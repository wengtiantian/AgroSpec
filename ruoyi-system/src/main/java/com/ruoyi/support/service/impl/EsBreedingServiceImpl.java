package com.ruoyi.support.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.support.mapper.EsBreedingMapper;
import com.ruoyi.support.domain.EsBreeding;
import com.ruoyi.support.service.IEsBreedingService;

/**
 * 养殖标准管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
@Service
public class EsBreedingServiceImpl implements IEsBreedingService 
{
    @Autowired
    private EsBreedingMapper esBreedingMapper;

    /**
     * 查询养殖标准管理
     * 
     * @param id 养殖标准管理主键
     * @return 养殖标准管理
     */
    @Override
    public EsBreeding selectEsBreedingById(Long id)
    {
        return esBreedingMapper.selectEsBreedingById(id);
    }

    /**
     * 查询养殖标准管理列表
     * 
     * @param esBreeding 养殖标准管理
     * @return 养殖标准管理
     */
    @Override
    public List<EsBreeding> selectEsBreedingList(EsBreeding esBreeding)
    {
        return esBreedingMapper.selectEsBreedingList(esBreeding);
    }

    /**
     * 新增养殖标准管理
     * 
     * @param esBreeding 养殖标准管理
     * @return 结果
     */
    @Override
    public int insertEsBreeding(EsBreeding esBreeding)
    {
        return esBreedingMapper.insertEsBreeding(esBreeding);
    }

    /**
     * 修改养殖标准管理
     * 
     * @param esBreeding 养殖标准管理
     * @return 结果
     */
    @Override
    public int updateEsBreeding(EsBreeding esBreeding)
    {
        return esBreedingMapper.updateEsBreeding(esBreeding);
    }

    /**
     * 批量删除养殖标准管理
     * 
     * @param ids 需要删除的养殖标准管理主键
     * @return 结果
     */
    @Override
    public int deleteEsBreedingByIds(Long[] ids)
    {
        return esBreedingMapper.deleteEsBreedingByIds(ids);
    }

    /**
     * 删除养殖标准管理信息
     * 
     * @param id 养殖标准管理主键
     * @return 结果
     */
    @Override
    public int deleteEsBreedingById(Long id)
    {
        return esBreedingMapper.deleteEsBreedingById(id);
    }
}
