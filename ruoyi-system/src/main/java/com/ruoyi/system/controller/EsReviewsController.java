package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.EsReviews;
import com.ruoyi.system.service.IEsReviewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评价Controller
 * 
 * @author ruoyi
 * @date 2025-01-15
 */
@RestController
@RequestMapping("/system/reviews")
public class EsReviewsController extends BaseController
{
    @Autowired
    private IEsReviewsService esReviewsService;

    /**
     * 查询评价列表
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsReviews esReviews)
    {
        startPage();
        List<EsReviews> list = esReviewsService.selectEsReviewsList(esReviews);
        return getDataTable(list);
    }

    /**
     * 导出评价列表
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:export')")
    @Log(title = "评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsReviews esReviews)
    {
        List<EsReviews> list = esReviewsService.selectEsReviewsList(esReviews);
        ExcelUtil<EsReviews> util = new ExcelUtil<EsReviews>(EsReviews.class);
        util.exportExcel(response, list, "评价数据");
    }

    /**
     * 获取评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esReviewsService.selectEsReviewsById(id));
    }

    /**
     * 新增评价
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:add')")
    @Log(title = "评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsReviews esReviews)
    {
        return toAjax(esReviewsService.insertEsReviews(esReviews));
    }
    @PostMapping("/addbyproducter")
    public AjaxResult addbyproducter(@RequestBody EsReviews esReviews)
    {
        Long userId = getUserId();
        esReviews.setUserId(userId);
        return toAjax(esReviewsService.insertEsReviews(esReviews));
    }


    /**
     * 修改评价
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:edit')")
    @Log(title = "评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsReviews esReviews)
    {
        return toAjax(esReviewsService.updateEsReviews(esReviews));
    }

    /**
     * 删除评价
     */
    @PreAuthorize("@ss.hasPermi('system:reviews:remove')")
    @Log(title = "评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esReviewsService.deleteEsReviewsByIds(ids));
    }
}
