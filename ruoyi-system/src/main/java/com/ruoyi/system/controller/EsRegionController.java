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
import com.ruoyi.system.domain.EsRegion;
import com.ruoyi.system.service.IEsRegionService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 地区(es_regions)Controller
 * 
 * @author 王创
 * @date 2024-06-20
 */
@RestController
@RequestMapping("/system/region")
public class EsRegionController extends BaseController
{
    @Autowired
    private IEsRegionService esRegionService;

    /**
     * 查询地区(es_regions)列表
     */
    @PreAuthorize("@ss.hasPermi('system:region:list')")
    @GetMapping("/list")
    public AjaxResult list(EsRegion esRegion)
    {
        
        List<EsRegion> list = esRegionService.selectEsRegionList(esRegion);
        return success(list);
    }

    /**
     * 导出地区(es_regions)列表
     */
    @PreAuthorize("@ss.hasPermi('system:region:export')")
    @Log(title = "地区(es_regions)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsRegion esRegion)
    {
        List<EsRegion> list = esRegionService.selectEsRegionList(esRegion);
        ExcelUtil<EsRegion> util = new ExcelUtil<EsRegion>(EsRegion.class);
        util.exportExcel(response, list, "地区(es_regions)数据");
    }

    /**
     * 获取地区(es_regions)详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:region:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esRegionService.selectEsRegionById(id));
    }

    /**
     * 新增地区(es_regions)
     */
    @PreAuthorize("@ss.hasPermi('system:region:add')")
    @Log(title = "地区(es_regions)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsRegion esRegion)
    {
        return toAjax(esRegionService.insertEsRegion(esRegion));
    }

    /**
     * 修改地区(es_regions)
     */
    @PreAuthorize("@ss.hasPermi('system:region:edit')")
    @Log(title = "地区(es_regions)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsRegion esRegion)
    {
        return toAjax(esRegionService.updateEsRegion(esRegion));
    }

    /**
     * 删除地区(es_regions)
     */
    @PreAuthorize("@ss.hasPermi('system:region:remove')")
    @Log(title = "地区(es_regions)", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esRegionService.deleteEsRegionByIds(ids));
    }
}
