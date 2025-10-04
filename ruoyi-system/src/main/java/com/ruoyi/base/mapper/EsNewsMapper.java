package com.ruoyi.base.mapper;

import java.util.List;
import com.ruoyi.base.domain.EsNews;

/**
 * 行业资讯Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-18
 */
public interface EsNewsMapper 
{
    /**
     * 通过URL查询行业资讯
     * 
     * @param url 资讯链接
     * @return 行业资讯
     */
    public EsNews selectEsNewsByUrl(String url);

    /**
     * 查询行业资讯
     * 
     * @param id 行业资讯主键
     * @return 行业资讯
     */
    public EsNews selectEsNewsById(Long id);

    /**
     * 查询行业资讯列表
     * 
     * @param esNews 行业资讯
     * @return 行业资讯集合
     */
    public List<EsNews> selectEsNewsList(EsNews esNews);

    /**
     * 新增行业资讯
     * 
     * @param esNews 行业资讯
     * @return 结果
     */
    public int insertEsNews(EsNews esNews);

    /**
     * 修改行业资讯
     * 
     * @param esNews 行业资讯
     * @return 结果
     */
    public int updateEsNews(EsNews esNews);

    /**
     * 删除行业资讯
     * 
     * @param id 行业资讯主键
     * @return 结果
     */
    public int deleteEsNewsById(Long id);

    /**
     * 批量删除行业资讯
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsNewsByIds(Long[] ids);
}
