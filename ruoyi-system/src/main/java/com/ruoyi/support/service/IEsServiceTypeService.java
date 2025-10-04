package com.ruoyi.support.service;

import java.util.List;
import com.ruoyi.support.domain.EsServiceType;

/**
 * 服务类型管理Service接口
 * 
 * @author wangchuang
 * @date 2024-08-01
 */
public interface IEsServiceTypeService 
{
    /**
     * 查询服务类型管理
     * 
     * @param id 服务类型管理主键
     * @return 服务类型管理
     */
    public EsServiceType selectEsServiceTypeById(Long id);

    /**
     * 查询服务类型管理列表
     * 
     * @param esServiceType 服务类型管理
     * @return 服务类型管理集合
     */
    public List<EsServiceType> selectEsServiceTypeList(EsServiceType esServiceType);

    /**
     * 新增服务类型管理
     * 
     * @param esServiceType 服务类型管理
     * @return 结果
     */
    public int insertEsServiceType(EsServiceType esServiceType);

    /**
     * 修改服务类型管理
     * 
     * @param esServiceType 服务类型管理
     * @return 结果
     */
    public int updateEsServiceType(EsServiceType esServiceType);

    /**
     * 批量删除服务类型管理
     * 
     * @param ids 需要删除的服务类型管理主键集合
     * @return 结果
     */
    public int deleteEsServiceTypeByIds(Long[] ids);

    /**
     * 删除服务类型管理信息
     * 
     * @param id 服务类型管理主键
     * @return 结果
     */
    public int deleteEsServiceTypeById(Long id);
}
