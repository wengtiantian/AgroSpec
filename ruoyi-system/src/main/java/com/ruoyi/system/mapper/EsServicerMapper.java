package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.EsServicer;

/**
 * 服务主体Mapper接口
 * 
 * @author wangchuang
 * @date 2024-06-19
 */
public interface EsServicerMapper 
{
    /**
     * 查询服务主体
     * 
     * @param id 服务主体主键
     * @return 服务主体
     */
    public EsServicer selectEsServicerById(Long id);

    /**
     * 查询服务主体列表
     * 
     * @param esServicer 服务主体
     * @return 服务主体集合
     */
    public List<EsServicer> selectEsServicerList(EsServicer esServicer);

    /**
     * 新增服务主体
     * 
     * @param esServicer 服务主体
     * @return 结果
     */
    public int insertEsServicer(EsServicer esServicer);

    /**
     * 修改服务主体
     * 
     * @param esServicer 服务主体
     * @return 结果
     */
    public int updateEsServicer(EsServicer esServicer);

    /**
     * 删除服务主体
     * 
     * @param id 服务主体主键
     * @return 结果
     */
    public int deleteEsServicerById(Long id);

    /**
     * 批量删除服务主体
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsServicerByIds(Long[] ids);

    EsServicer checkAccountPhoneUnique(String accountPhone);


    /**
     * 根据 user_id 查询服务主体
     *
     * @param userId 用户 ID
     * @return 服务主体列表
     */
    EsServicer selectEsServicerByUserId(Long userId);

}
