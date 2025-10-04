package com.ruoyi.base.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
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
import com.ruoyi.base.domain.EsReviews;
import com.ruoyi.base.service.IEsReviewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.utils.SQApiClient;
import com.ruoyi.utils.SQResponse;

/**
 * 评论管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@RestController
@RequestMapping("/base/reviews")
public class EsReviewsController extends BaseController
{
    @Autowired
    private IEsReviewsService esReviewsService;

    @Autowired
    private SQApiClient sqApiClient;

    /**
     * 查询评论管理列表
     */
    @PreAuthorize("@ss.hasPermi('base:reviews:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsReviews esReviews)
    {
        startPage();
        List<EsReviews> list = esReviewsService.selectEsReviewsList(esReviews);
        return getDataTable(list);
    }

    /**
     * 导出评论管理列表
     */
    @PreAuthorize("@ss.hasPermi('base:reviews:export')")
    @Log(title = "评论管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsReviews esReviews)
    {
        List<EsReviews> list = esReviewsService.selectEsReviewsList(esReviews);
        ExcelUtil<EsReviews> util = new ExcelUtil<EsReviews>(EsReviews.class);
        util.exportExcel(response, list, "评论管理数据");
    }

    /**
     * 获取评论管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('base:reviews:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esReviewsService.selectEsReviewsById(id));
    }

    /**
     * 新增评论管理
     */
    @PreAuthorize("@ss.hasPermi('base:reviews:add')")
    @Log(title = "评论管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsReviews esReviews)
    {
        return toAjax(esReviewsService.insertEsReviews(esReviews));
    }

    /**
     * 修改评论管理
     */
    @PreAuthorize("@ss.hasPermi('base:reviews:edit')")
    @Log(title = "评论管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsReviews esReviews)
    {
        return toAjax(esReviewsService.updateEsReviews(esReviews));
    }

    /**
     * 删除评论管理
     */
    @PreAuthorize("@ss.hasPermi('base:reviews:remove')")
    @Log(title = "评论管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esReviewsService.deleteEsReviewsByIds(ids));
    }

    /**
     * 获取服务主体评分和图表
     */
    @GetMapping("/servicer/{servicerId}/stats")
    public AjaxResult getServicerStats(@PathVariable Long servicerId) {
        try {
            com.ruoyi.utils.SQResponse response = sqApiClient.getServiceQuality(servicerId);
            if (response != null && response.getCode() == 0) {
                Map<String, Object> data = response.getData();
                // 添加图表URL
                data.put("chartUrls", new HashMap<String, String>() {{
                    put("pareto", "http://47.92.95.129:9898/media/Pareto_chart/" + servicerId + ".jpg");
                    put("wordcloud", "http://47.92.95.129:9898/media/WordCloud/" + servicerId + ".jpg");
                    put("bars", "http://47.92.95.129:9898/media/Bars/" + servicerId + ".jpg");
                    put("radar", "http://47.92.95.129:9898/media/Radar/" + servicerId + ".jpg");
                }});
                return success(data);
            }
            return error("获取服务主体统计信息失败");
        } catch (Exception e) {
            return error("获取服务主体统计信息失败: " + e.getMessage());
        }
    }
}
