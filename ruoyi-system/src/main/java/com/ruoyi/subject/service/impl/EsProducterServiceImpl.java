package com.ruoyi.subject.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.subject.mapper.EsProducterMapper;
import com.ruoyi.subject.domain.EsProducter;
import com.ruoyi.subject.service.IEsProducterService;

/**
 * 生产主体管理Service业务层处理
 * 
 * @author wangchuang
 * @date 2024-07-14
 */
@Service
public class EsProducterServiceImpl implements IEsProducterService 
{
    @Autowired
    private EsProducterMapper esProducterMapper;

    /**
     * 查询生产主体管理
     * 
     * @param id 生产主体管理主键
     * @return 生产主体管理
     */
    @Override
    public EsProducter selectEsProducterById(Long id)
    {
        return esProducterMapper.selectEsProducterById(id);
    }

    /**
     * 查询生产主体管理列表
     * 
     * @param esProducter 生产主体管理
     * @return 生产主体管理
     */
    @Override
    public List<EsProducter> selectEsProducterList(EsProducter esProducter)
    {
        return esProducterMapper.selectEsProducterList(esProducter);
    }

    /**
     * 新增生产主体管理
     * 
     * @param esProducter 生产主体管理
     * @return 结果
     */
    @Override
    public int insertEsProducter(EsProducter esProducter)
    {
        esProducter.setCreateTime(DateUtils.getNowDate());
        return esProducterMapper.insertEsProducter(esProducter);
    }

    /**
     * 修改生产主体管理
     * 
     * @param esProducter 生产主体管理
     * @return 结果
     */
    @Override
    public int updateEsProducter(EsProducter esProducter)
    {
        esProducter.setUpdateTime(DateUtils.getNowDate());
        return esProducterMapper.updateEsProducter(esProducter);
    }

    /**
     * 批量删除生产主体管理
     * 
     * @param ids 需要删除的生产主体管理主键
     * @return 结果
     */
    @Override
    public int deleteEsProducterByIds(Long[] ids)
    {
        return esProducterMapper.deleteEsProducterByIds(ids);
    }

    /**
     * 删除生产主体管理信息
     * 
     * @param id 生产主体管理主键
     * @return 结果
     */
    @Override
    public int deleteEsProducterById(Long id)
    {
        return esProducterMapper.deleteEsProducterById(id);
    }
}
