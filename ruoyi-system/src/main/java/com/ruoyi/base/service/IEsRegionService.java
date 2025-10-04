package com.ruoyi.base.service;

import java.util.List;
import com.ruoyi.base.domain.EsRegion;

/**
 * 地区(es_regions)Service接口
 * 
 * @author 王创
 * @date 2024-06-20
 */
public interface IEsRegionService 
{
    /**
     * 查询地区(es_regions)
     * 
     * @param id 地区(es_regions)主键
     * @return 地区(es_regions)
     */
    public EsRegion selectEsRegionById(Long id);

    /**
     * 查询地区(es_regions)列表
     * 
     * @param esRegion 地区(es_regions)
     * @return 地区(es_regions)集合
     */
    public List<EsRegion> selectEsRegionList(EsRegion esRegion);

    /**
     * 新增地区(es_regions)
     * 
     * @param esRegion 地区(es_regions)
     * @return 结果
     */
    public int insertEsRegion(EsRegion esRegion);

    /**
     * 修改地区(es_regions)
     * 
     * @param esRegion 地区(es_regions)
     * @return 结果
     */
    public int updateEsRegion(EsRegion esRegion);

    /**
     * 批量删除地区(es_regions)
     * 
     * @param ids 需要删除的地区(es_regions)主键集合
     * @return 结果
     */
    public int deleteEsRegionByIds(Long[] ids);

    /**
     * 删除地区(es_regions)信息
     * 
     * @param id 地区(es_regions)主键
     * @return 结果
     */
    public int deleteEsRegionById(Long id);
}
