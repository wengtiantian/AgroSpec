package com.ruoyi.subject.service;

import java.util.List;
import com.ruoyi.subject.domain.EsProducter;

/**
 * 生产主体管理Service接口
 * 
 * @author wangchuang
 * @date 2024-07-14
 */
public interface IEsProducterService 
{
    /**
     * 查询生产主体管理
     * 
     * @param id 生产主体管理主键
     * @return 生产主体管理
     */
    public EsProducter selectEsProducterById(Long id);

    /**
     * 查询生产主体管理列表
     * 
     * @param esProducter 生产主体管理
     * @return 生产主体管理集合
     */
    public List<EsProducter> selectEsProducterList(EsProducter esProducter);

    /**
     * 新增生产主体管理
     * 
     * @param esProducter 生产主体管理
     * @return 结果
     */
    public int insertEsProducter(EsProducter esProducter);

    /**
     * 修改生产主体管理
     * 
     * @param esProducter 生产主体管理
     * @return 结果
     */
    public int updateEsProducter(EsProducter esProducter);

    /**
     * 批量删除生产主体管理
     * 
     * @param ids 需要删除的生产主体管理主键集合
     * @return 结果
     */
    public int deleteEsProducterByIds(Long[] ids);

    /**
     * 删除生产主体管理信息
     * 
     * @param id 生产主体管理主键
     * @return 结果
     */
    public int deleteEsProducterById(Long id);
}
