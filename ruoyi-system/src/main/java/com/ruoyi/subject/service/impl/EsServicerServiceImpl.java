package com.ruoyi.subject.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.subject.mapper.EsServicerMapper;
import com.ruoyi.subject.domain.EsServicer;
import com.ruoyi.subject.service.IEsServicerService;

/**
 * 服务主体管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@Service
public class EsServicerServiceImpl implements IEsServicerService 
{
    @Autowired
    private EsServicerMapper esServicerMapper;

    /**
     * 查询服务主体管理
     * 
     * @param id 服务主体管理主键
     * @return 服务主体管理
     */
    @Override
    public EsServicer selectEsServicerById(Long id)
    {
        return esServicerMapper.selectEsServicerById(id);
    }

    /**
     * 查询服务主体管理列表
     * 
     * @param esServicer 服务主体管理
     * @return 服务主体管理
     */
    @Override
    public List<EsServicer> selectEsServicerList(EsServicer esServicer)
    {
        return esServicerMapper.selectEsServicerList(esServicer);
    }

    /**
     * 新增服务主体管理
     * 
     * @param esServicer 服务主体管理
     * @return 结果
     */
    @Override
    public int insertEsServicer(EsServicer esServicer)
    {
        esServicer.setCreateTime(DateUtils.getNowDate());
        return esServicerMapper.insertEsServicer(esServicer);
    }

    /**
     * 修改服务主体管理
     * 
     * @param esServicer 服务主体管理
     * @return 结果
     */
    @Override
    public int updateEsServicer(EsServicer esServicer)
    {
        esServicer.setUpdateTime(DateUtils.getNowDate());
        return esServicerMapper.updateEsServicer(esServicer);
    }

    /**
     * 批量删除服务主体管理
     * 
     * @param ids 需要删除的服务主体管理主键
     * @return 结果
     */
    @Override
    public int deleteEsServicerByIds(Long[] ids)
    {
        return esServicerMapper.deleteEsServicerByIds(ids);
    }

    /**
     * 删除服务主体管理信息
     * 
     * @param id 服务主体管理主键
     * @return 结果
     */
    @Override
    public int deleteEsServicerById(Long id)
    {
        return esServicerMapper.deleteEsServicerById(id);
    }

    @Override
    public EsServicer selectEsServicerByUserId(Long userId) {
        EsServicer query = new EsServicer();
        query.setUserId(userId);
        List<EsServicer> list = esServicerMapper.selectEsServicerList(query);
        return list.isEmpty() ? null : list.get(0);
    }

    /**
     * 更新服务主体认证状态
     * 
     * @param id 服务主体主键
     * @param isAuth 认证状态（0：未认证，1：等待审核，2：已认证）
     * @return 结果
     */
    @Override
    public int updateEsServicerStatus(Long id, Integer isAuth)
    {
        EsServicer esServicer = new EsServicer();
        esServicer.setId(id);
        esServicer.setIsAuth(isAuth);
        esServicer.setUpdateTime(DateUtils.getNowDate());
        return esServicerMapper.updateEsServicer(esServicer);
    }
}
