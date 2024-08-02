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
import com.ruoyi.system.domain.EsStandards;
import com.ruoyi.system.service.IEsStandardsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标准管理Controller
 * 
 * @author wangchuang
 * @date 2024-07-14
 */
@RestController
@RequestMapping("/system/standards")
public class EsStandardsController extends BaseController
{
    @Autowired
    private IEsStandardsService esStandardsService;

    /**
     * 查询标准管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:standards:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsStandards esStandards)
    {
        startPage();
        List<EsStandards> list = esStandardsService.selectEsStandardsList(esStandards);
        return getDataTable(list);
    }

    /**
     * 导出标准管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:standards:export')")
    @Log(title = "标准管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsStandards esStandards)
    {
        List<EsStandards> list = esStandardsService.selectEsStandardsList(esStandards);
        ExcelUtil<EsStandards> util = new ExcelUtil<EsStandards>(EsStandards.class);
        util.exportExcel(response, list, "标准管理数据");
    }

    /**
     * 获取标准管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:standards:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esStandardsService.selectEsStandardsById(id));
    }

    /**
     * 新增标准管理
     */
    @PreAuthorize("@ss.hasPermi('system:standards:add')")
    @Log(title = "标准管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsStandards esStandards)
    {
        return toAjax(esStandardsService.insertEsStandards(esStandards));
    }

    /**
     * 修改标准管理
     */
    @PreAuthorize("@ss.hasPermi('system:standards:edit')")
    @Log(title = "标准管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsStandards esStandards)
    {
        return toAjax(esStandardsService.updateEsStandards(esStandards));
    }

    /**
     * 删除标准管理
     */
    @PreAuthorize("@ss.hasPermi('system:standards:remove')")
    @Log(title = "标准管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esStandardsService.deleteEsStandardsByIds(ids));
    }
}
