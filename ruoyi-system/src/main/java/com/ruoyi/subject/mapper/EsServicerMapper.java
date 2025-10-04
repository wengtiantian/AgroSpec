package com.ruoyi.subject.mapper;

import java.util.List;
import com.ruoyi.subject.domain.EsServicer;

/**
 * 服务主体管理Mapper接口
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
public interface EsServicerMapper 
{
    /**
     * 查询服务主体管理
     * 
     * @param id 服务主体管理主键
     * @return 服务主体管理
     */
    public EsServicer selectEsServicerById(Long id);

    /**
     * 查询服务主体管理列表
     * 
     * @param esServicer 服务主体管理
     * @return 服务主体管理集合
     */
    public List<EsServicer> selectEsServicerList(EsServicer esServicer);

    /**
     * 新增服务主体管理
     * 
     * @param esServicer 服务主体管理
     * @return 结果
     */
    public int insertEsServicer(EsServicer esServicer);

    /**
     * 修改服务主体管理
     * 
     * @param esServicer 服务主体管理
     * @return 结果
     */
    public int updateEsServicer(EsServicer esServicer);

    /**
     * 删除服务主体管理
     * 
     * @param id 服务主体管理主键
     * @return 结果
     */
    public int deleteEsServicerById(Long id);

    /**
     * 批量删除服务主体管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsServicerByIds(Long[] ids);
}
