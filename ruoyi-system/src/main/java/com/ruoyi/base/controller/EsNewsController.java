package com.ruoyi.base.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.base.domain.EsNews;
import com.ruoyi.base.service.IEsNewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 行业资讯Controller
 * 
 * @author ruoyi
 * @date 2025-09-18
 */
@RestController
@RequestMapping("/base/news")
public class EsNewsController extends BaseController
{
    @Autowired
    private IEsNewsService esNewsService;

    /**
     * 查询行业资讯列表
     */
    @PreAuthorize("@ss.hasPermi('base:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsNews esNews)
    {
        startPage();
        List<EsNews> list = esNewsService.selectEsNewsList(esNews);
        return getDataTable(list);
    }

    /**
     * 导出行业资讯列表
     */
    @PreAuthorize("@ss.hasPermi('base:news:export')")
    @Log(title = "行业资讯", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsNews esNews)
    {
        List<EsNews> list = esNewsService.selectEsNewsList(esNews);
        ExcelUtil<EsNews> util = new ExcelUtil<EsNews>(EsNews.class);
        util.exportExcel(response, list, "行业资讯数据");
    }

    /**
     * 获取行业资讯详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:news:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esNewsService.selectEsNewsById(id));
    }

    /**
     * 新增行业资讯
     */
    @PreAuthorize("@ss.hasPermi('base:news:add')")
    @Log(title = "行业资讯", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsNews esNews)
    {
        return toAjax(esNewsService.insertEsNews(esNews));
    }

    /**
     * 修改行业资讯
     */
    @PreAuthorize("@ss.hasPermi('base:news:edit')")
    @Log(title = "行业资讯", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsNews esNews)
    {
        return toAjax(esNewsService.updateEsNews(esNews));
    }

    /**
     * 删除行业资讯
     */
    @PreAuthorize("@ss.hasPermi('base:news:remove')")
    @Log(title = "行业资讯", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esNewsService.deleteEsNewsByIds(ids));
    }
}
