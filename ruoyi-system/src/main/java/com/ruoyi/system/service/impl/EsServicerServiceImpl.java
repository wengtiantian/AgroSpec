package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EsServicerMapper;
import com.ruoyi.system.domain.EsServicer;
import com.ruoyi.system.service.IEsServicerService;

/**
 * 服务主体Service业务层处理
 * 
 * @author wangchuang
 * @date 2024-06-19
 */
@Service
public class EsServicerServiceImpl implements IEsServicerService 
{
    @Autowired
    private EsServicerMapper esServicerMapper;

    /**
     * 查询服务主体
     * 
     * @param id 服务主体主键
     * @return 服务主体
     */
    @Override
    public EsServicer selectEsServicerById(Long id)
    {
        return esServicerMapper.selectEsServicerById(id);
    }

    /**
     * 查询服务主体列表
     * 
     * @param esServicer 服务主体
     * @return 服务主体
     */
    @Override
    public List<EsServicer> selectEsServicerList(EsServicer esServicer)
    {
        return esServicerMapper.selectEsServicerList(esServicer);
    }

    /**
     * 新增服务主体
     * 
     * @param esServicer 服务主体
     * @return 结果
     */
    @Override
    public int insertEsServicer(EsServicer esServicer)
    {
        esServicer.setCreateTime(DateUtils.getNowDate());
        return esServicerMapper.insertEsServicer(esServicer);
    }



    /**
     * 修改服务主体
     * 
     * @param esServicer 服务主体
     * @return 结果
     */
    @Override
    public int updateEsServicer(EsServicer esServicer)
    {
        esServicer.setUpdateTime(DateUtils.getNowDate());
        return esServicerMapper.updateEsServicer(esServicer);
    }

    /**
     * 批量删除服务主体
     * 
     * @param ids 需要删除的服务主体主键
     * @return 结果
     */
    @Override
    public int deleteEsServicerByIds(Long[] ids)
    {
        return esServicerMapper.deleteEsServicerByIds(ids);
    }

    /**
     * 删除服务主体信息
     * 
     * @param id 服务主体主键
     * @return 结果
     */
    @Override
    public int deleteEsServicerById(Long id)
    {
        return esServicerMapper.deleteEsServicerById(id);
    }

    @Override
    public boolean checkAccountPhoneUnique(EsServicer esServicer) {

        return UserConstants.UNIQUE;
    }

    @Override
    public EsServicer selectEsServicerByUserId(Long userId) {
        return esServicerMapper.selectEsServicerByUserId(userId);
    }


}
