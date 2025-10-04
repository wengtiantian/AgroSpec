package com.ruoyi.base.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.base.mapper.EsNewsMapper;
import com.ruoyi.base.domain.EsNews;
import com.ruoyi.base.service.IEsNewsService;
import com.ruoyi.common.exception.ServiceException;

/**
 * 行业资讯Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-09-18
 */
@Service
public class EsNewsServiceImpl implements IEsNewsService 
{
    @Autowired
    private EsNewsMapper esNewsMapper;

    /**
     * 查询行业资讯
     * 
     * @param id 行业资讯主键
     * @return 行业资讯
     */
    @Override
    public EsNews selectEsNewsById(Long id)
    {
        return esNewsMapper.selectEsNewsById(id);
    }

    /**
     * 查询行业资讯列表
     * 
     * @param esNews 行业资讯
     * @return 行业资讯
     */
    @Override
    public List<EsNews> selectEsNewsList(EsNews esNews)
    {
        return esNewsMapper.selectEsNewsList(esNews);
    }

    /**
     * 新增行业资讯
     * 
     * @param esNews 行业资讯
     * @return 结果
     */
    @Override
    public EsNews selectEsNewsByUrl(String url)
    {
        return esNewsMapper.selectEsNewsByUrl(url);
    }

    /**
     * 新增前校验URL唯一性
     */
    @Override
    public int insertEsNews(EsNews esNews)
    {
        if (esNews.getUrl() != null && !esNews.getUrl().isEmpty()) {
            EsNews existed = esNewsMapper.selectEsNewsByUrl(esNews.getUrl());
            if (existed != null) {
                throw new ServiceException("该资讯链接已存在，不能重复添加");
            }
        }
        return esNewsMapper.insertEsNews(esNews);
    }

    /**
     * 修改行业资讯
     * 
     * @param esNews 行业资讯
     * @return 结果
     */
    @Override
    public int updateEsNews(EsNews esNews)
    {
        return esNewsMapper.updateEsNews(esNews);
    }

    /**
     * 批量删除行业资讯
     * 
     * @param ids 需要删除的行业资讯主键
     * @return 结果
     */
    @Override
    public int deleteEsNewsByIds(Long[] ids)
    {
        return esNewsMapper.deleteEsNewsByIds(ids);
    }

    /**
     * 删除行业资讯信息
     * 
     * @param id 行业资讯主键
     * @return 结果
     */
    @Override
    public int deleteEsNewsById(Long id)
    {
        return esNewsMapper.deleteEsNewsById(id);
    }
}
