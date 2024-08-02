package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EsRegionMapper;
import com.ruoyi.system.domain.EsRegion;
import com.ruoyi.system.service.IEsRegionService;

/**
 * 地区(es_regions)Service业务层处理
 * 
 * @author 王创
 * @date 2024-06-20
 */
@Service
public class EsRegionServiceImpl implements IEsRegionService 
{
    @Autowired
    private EsRegionMapper esRegionMapper;

    /**
     * 查询地区(es_regions)
     * 
     * @param id 地区(es_regions)主键
     * @return 地区(es_regions)
     */
    @Override
    public EsRegion selectEsRegionById(Long id)
    {
        return esRegionMapper.selectEsRegionById(id);
    }

    /**
     * 查询地区(es_regions)列表
     * 
     * @param esRegion 地区(es_regions)
     * @return 地区(es_regions)
     */
    @Override
    public List<EsRegion> selectEsRegionList(EsRegion esRegion)
    {
        return esRegionMapper.selectEsRegionList(esRegion);
    }

    /**
     * 新增地区(es_regions)
     * 
     * @param esRegion 地区(es_regions)
     * @return 结果
     */
    @Override
    public int insertEsRegion(EsRegion esRegion)
    {
        return esRegionMapper.insertEsRegion(esRegion);
    }

    /**
     * 修改地区(es_regions)
     * 
     * @param esRegion 地区(es_regions)
     * @return 结果
     */
    @Override
    public int updateEsRegion(EsRegion esRegion)
    {
        return esRegionMapper.updateEsRegion(esRegion);
    }

    /**
     * 批量删除地区(es_regions)
     * 
     * @param ids 需要删除的地区(es_regions)主键
     * @return 结果
     */
    @Override
    public int deleteEsRegionByIds(Long[] ids)
    {
        return esRegionMapper.deleteEsRegionByIds(ids);
    }

    /**
     * 删除地区(es_regions)信息
     * 
     * @param id 地区(es_regions)主键
     * @return 结果
     */
    @Override
    public int deleteEsRegionById(Long id)
    {
        return esRegionMapper.deleteEsRegionById(id);
    }
}
