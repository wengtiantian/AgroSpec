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
import com.ruoyi.support.domain.EsBreeding;
import com.ruoyi.support.service.IEsBreedingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 养殖标准管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-11
 */
@RestController
@RequestMapping("/support/breeding")
public class EsBreedingController extends BaseController
{
    @Autowired
    private IEsBreedingService esBreedingService;

    /**
     * 查询养殖标准管理列表
     */
    @PreAuthorize("@ss.hasPermi('support:breeding:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsBreeding esBreeding)
    {
        startPage();
        List<EsBreeding> list = esBreedingService.selectEsBreedingList(esBreeding);
        return getDataTable(list);
    }

    /**
     * 导出养殖标准管理列表
     */
    @PreAuthorize("@ss.hasPermi('support:breeding:export')")
    @Log(title = "养殖标准管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsBreeding esBreeding)
    {
        List<EsBreeding> list = esBreedingService.selectEsBreedingList(esBreeding);
        ExcelUtil<EsBreeding> util = new ExcelUtil<EsBreeding>(EsBreeding.class);
        util.exportExcel(response, list, "养殖标准管理数据");
    }

    /**
     * 获取养殖标准管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('support:breeding:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esBreedingService.selectEsBreedingById(id));
    }

    /**
     * 新增养殖标准管理
     */
    @PreAuthorize("@ss.hasPermi('support:breeding:add')")
    @Log(title = "养殖标准管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsBreeding esBreeding)
    {
        return toAjax(esBreedingService.insertEsBreeding(esBreeding));
    }

    /**
     * 修改养殖标准管理
     */
    @PreAuthorize("@ss.hasPermi('support:breeding:edit')")
    @Log(title = "养殖标准管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsBreeding esBreeding)
    {
        return toAjax(esBreedingService.updateEsBreeding(esBreeding));
    }

    /**
     * 删除养殖标准管理
     */
    @PreAuthorize("@ss.hasPermi('support:breeding:remove')")
    @Log(title = "养殖标准管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esBreedingService.deleteEsBreedingByIds(ids));
    }
}
