package com.ruoyi.support.controller;

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
import com.ruoyi.support.domain.EsCultivation;
import com.ruoyi.support.service.IEsCultivationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 种植标准管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-07
 */
@RestController
@RequestMapping("/support/cultivation")
public class EsCultivationController extends BaseController
{
    @Autowired
    private IEsCultivationService esCultivationService;

    /**
     * 查询种植标准管理列表
     */
    @PreAuthorize("@ss.hasPermi('support:cultivation:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsCultivation esCultivation)
    {
        startPage();
        List<EsCultivation> list = esCultivationService.selectEsCultivationList(esCultivation);
        return getDataTable(list);
    }

    /**
     * 导出种植标准管理列表
     */
    @PreAuthorize("@ss.hasPermi('support:cultivation:export')")
    @Log(title = "种植标准管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsCultivation esCultivation)
    {
        List<EsCultivation> list = esCultivationService.selectEsCultivationList(esCultivation);
        ExcelUtil<EsCultivation> util = new ExcelUtil<EsCultivation>(EsCultivation.class);
        util.exportExcel(response, list, "种植标准管理数据");
    }

    /**
     * 获取种植标准管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('support:cultivation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esCultivationService.selectEsCultivationById(id));
    }

    /**
     * 新增种植标准管理
     */
    @PreAuthorize("@ss.hasPermi('support:cultivation:add')")
    @Log(title = "种植标准管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsCultivation esCultivation)
    {
        return toAjax(esCultivationService.insertEsCultivation(esCultivation));
    }

    /**
     * 修改种植标准管理
     */
    @PreAuthorize("@ss.hasPermi('support:cultivation:edit')")
    @Log(title = "种植标准管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsCultivation esCultivation)
    {
        return toAjax(esCultivationService.updateEsCultivation(esCultivation));
    }

    /**
     * 删除种植标准管理
     */
    @PreAuthorize("@ss.hasPermi('support:cultivation:remove')")
    @Log(title = "种植标准管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esCultivationService.deleteEsCultivationByIds(ids));
    }
}
