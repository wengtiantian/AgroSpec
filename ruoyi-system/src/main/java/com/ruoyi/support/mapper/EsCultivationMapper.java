package com.ruoyi.support.mapper;

import java.util.List;
import com.ruoyi.support.domain.EsCultivation;

/**
 * 种植标准管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-07
 */
public interface EsCultivationMapper 
{
    /**
     * 查询种植标准管理
     * 
     * @param id 种植标准管理主键
     * @return 种植标准管理
     */
    public EsCultivation selectEsCultivationById(Long id);

    /**
     * 查询种植标准管理列表
     * 
     * @param esCultivation 种植标准管理
     * @return 种植标准管理集合
     */
    public List<EsCultivation> selectEsCultivationList(EsCultivation esCultivation);

    /**
     * 新增种植标准管理
     * 
     * @param esCultivation 种植标准管理
     * @return 结果
     */
    public int insertEsCultivation(EsCultivation esCultivation);

    /**
     * 修改种植标准管理
     * 
     * @param esCultivation 种植标准管理
     * @return 结果
     */
    public int updateEsCultivation(EsCultivation esCultivation);

    /**
     * 删除种植标准管理
     * 
     * @param id 种植标准管理主键
     * @return 结果
     */
    public int deleteEsCultivationById(Long id);

    /**
     * 批量删除种植标准管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsCultivationByIds(Long[] ids);
}
