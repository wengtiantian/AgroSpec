package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EsStandards;

/**
 * 标准管理Mapper接口
 * 
 * @author wangchuang
 * @date 2024-07-14
 */
public interface EsStandardsMapper 
{
    /**
     * 查询标准管理
     * 
     * @param id 标准管理主键
     * @return 标准管理
     */
    public EsStandards selectEsStandardsById(Long id);

    /**
     * 查询标准管理列表
     * 
     * @param esStandards 标准管理
     * @return 标准管理集合
     */
    public List<EsStandards> selectEsStandardsList(EsStandards esStandards);

    /**
     * 新增标准管理
     * 
     * @param esStandards 标准管理
     * @return 结果
     */
    public int insertEsStandards(EsStandards esStandards);

    /**
     * 修改标准管理
     * 
     * @param esStandards 标准管理
     * @return 结果
     */
    public int updateEsStandards(EsStandards esStandards);

    /**
     * 删除标准管理
     * 
     * @param id 标准管理主键
     * @return 结果
     */
    public int deleteEsStandardsById(Long id);

    /**
     * 批量删除标准管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsStandardsByIds(Long[] ids);
}
