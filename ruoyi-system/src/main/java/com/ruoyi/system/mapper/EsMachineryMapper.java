package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EsMachinery;

/**
 * 农机Mapper接口
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
public interface EsMachineryMapper 
{
    /**
     * 查询农机
     * 
     * @param id 农机主键
     * @return 农机
     */
    public EsMachinery selectEsMachineryById(Long id);

    /**
     * 查询农机列表
     * 
     * @param esMachinery 农机
     * @return 农机集合
     */
    public List<EsMachinery> selectEsMachineryList(EsMachinery esMachinery);

    /**
     * 新增农机
     * 
     * @param esMachinery 农机
     * @return 结果
     */
    public int insertEsMachinery(EsMachinery esMachinery);

    /**
     * 修改农机
     * 
     * @param esMachinery 农机
     * @return 结果
     */
    public int updateEsMachinery(EsMachinery esMachinery);

    /**
     * 删除农机
     * 
     * @param id 农机主键
     * @return 结果
     */
    public int deleteEsMachineryById(Long id);

    /**
     * 批量删除农机
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsMachineryByIds(Long[] ids);
}
