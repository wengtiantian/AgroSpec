package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EsServiceTypeMapper;
import com.ruoyi.system.domain.EsServiceType;
import com.ruoyi.system.service.IEsServiceTypeService;

/**
 * 服务类型管理Service业务层处理
 * 
 * @author wangchuang
 * @date 2024-08-01
 */
@Service
public class EsServiceTypeServiceImpl implements IEsServiceTypeService 
{
    @Autowired
    private EsServiceTypeMapper esServiceTypeMapper;

    /**
     * 查询服务类型管理
     * 
     * @param id 服务类型管理主键
     * @return 服务类型管理
     */
    @Override
    public EsServiceType selectEsServiceTypeById(Long id)
    {
        return esServiceTypeMapper.selectEsServiceTypeById(id);
    }

    /**
     * 查询服务类型管理列表
     * 
     * @param esServiceType 服务类型管理
     * @return 服务类型管理
     */
    @Override
    public List<EsServiceType> selectEsServiceTypeList(EsServiceType esServiceType)
    {
        return esServiceTypeMapper.selectEsServiceTypeList(esServiceType);
    }

    /**
     * 新增服务类型管理
     * 
     * @param esServiceType 服务类型管理
     * @return 结果
     */
    @Override
    public int insertEsServiceType(EsServiceType esServiceType)
    {
        esServiceType.setCreateTime(DateUtils.getNowDate());
        return esServiceTypeMapper.insertEsServiceType(esServiceType);
    }

    /**
     * 修改服务类型管理
     * 
     * @param esServiceType 服务类型管理
     * @return 结果
     */
    @Override
    public int updateEsServiceType(EsServiceType esServiceType)
    {
        esServiceType.setUpdateTime(DateUtils.getNowDate());
        return esServiceTypeMapper.updateEsServiceType(esServiceType);
    }

    /**
     * 批量删除服务类型管理
     * 
     * @param ids 需要删除的服务类型管理主键
     * @return 结果
     */
    @Override
    public int deleteEsServiceTypeByIds(Long[] ids)
    {
        return esServiceTypeMapper.deleteEsServiceTypeByIds(ids);
    }

    /**
     * 删除服务类型管理信息
     * 
     * @param id 服务类型管理主键
     * @return 结果
     */
    @Override
    public int deleteEsServiceTypeById(Long id)
    {
        return esServiceTypeMapper.deleteEsServiceTypeById(id);
    }
}
