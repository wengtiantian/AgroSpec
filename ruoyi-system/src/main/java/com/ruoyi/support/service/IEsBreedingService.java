package com.ruoyi.support.service;

import java.util.List;
import com.ruoyi.support.domain.EsBreeding;

/**
 * 养殖标准管理Service接口
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
public interface IEsBreedingService 
{
    /**
     * 查询养殖标准管理
     * 
     * @param id 养殖标准管理主键
     * @return 养殖标准管理
     */
    public EsBreeding selectEsBreedingById(Long id);

    /**
     * 查询养殖标准管理列表
     * 
     * @param esBreeding 养殖标准管理
     * @return 养殖标准管理集合
     */
    public List<EsBreeding> selectEsBreedingList(EsBreeding esBreeding);

    /**
     * 新增养殖标准管理
     * 
     * @param esBreeding 养殖标准管理
     * @return 结果
     */
    public int insertEsBreeding(EsBreeding esBreeding);

    /**
     * 修改养殖标准管理
     * 
     * @param esBreeding 养殖标准管理
     * @return 结果
     */
    public int updateEsBreeding(EsBreeding esBreeding);

    /**
     * 批量删除养殖标准管理
     * 
     * @param ids 需要删除的养殖标准管理主键集合
     * @return 结果
     */
    public int deleteEsBreedingByIds(Long[] ids);

    /**
     * 删除养殖标准管理信息
     * 
     * @param id 养殖标准管理主键
     * @return 结果
     */
    public int deleteEsBreedingById(Long id);
}
