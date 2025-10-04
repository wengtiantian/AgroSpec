package com.ruoyi.support.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.support.mapper.EsMachineryMapper;
import com.ruoyi.support.domain.EsMachinery;
import com.ruoyi.support.service.IEsMachineryService;

/**
 * 农机Service业务层处理
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
@Service
public class EsMachineryServiceImpl implements IEsMachineryService 
{
    @Autowired
    private EsMachineryMapper esMachineryMapper;

    /**
     * 查询农机
     * 
     * @param id 农机主键
     * @return 农机
     */
    @Override
    public EsMachinery selectEsMachineryById(Long id)
    {
        return esMachineryMapper.selectEsMachineryById(id);
    }

    /**
     * 查询农机列表
     * 
     * @param esMachinery 农机
     * @return 农机
     */
    @Override
    public List<EsMachinery> selectEsMachineryList(EsMachinery esMachinery)
    {
        return esMachineryMapper.selectEsMachineryList(esMachinery);
    }

    /**
     * 新增农机
     * 
     * @param esMachinery 农机
     * @return 结果
     */
    @Override
    public int insertEsMachinery(EsMachinery esMachinery)
    {
        esMachinery.setCreateTime(DateUtils.getNowDate());
        return esMachineryMapper.insertEsMachinery(esMachinery);
    }

    /**
     * 修改农机
     * 
     * @param esMachinery 农机
     * @return 结果
     */
    @Override
    public int updateEsMachinery(EsMachinery esMachinery)
    {
        esMachinery.setUpdateTime(DateUtils.getNowDate());
        return esMachineryMapper.updateEsMachinery(esMachinery);
    }

    /**
     * 批量删除农机
     * 
     * @param ids 需要删除的农机主键
     * @return 结果
     */
    @Override
    public int deleteEsMachineryByIds(Long[] ids)
    {
        return esMachineryMapper.deleteEsMachineryByIds(ids);
    }

    /**
     * 删除农机信息
     * 
     * @param id 农机主键
     * @return 结果
     */
    @Override
    public int deleteEsMachineryById(Long id)
    {
        return esMachineryMapper.deleteEsMachineryById(id);
    }
}
