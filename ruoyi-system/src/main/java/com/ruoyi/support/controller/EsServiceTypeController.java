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
import com.ruoyi.support.domain.EsServiceType;
import com.ruoyi.support.service.IEsServiceTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 服务类型管理Controller
 * 
 * @author wangchuang
 * @date 2024-08-01
 */
@RestController
@RequestMapping("/support/type")
public class EsServiceTypeController extends BaseController
{
    @Autowired
    private IEsServiceTypeService esServiceTypeService;

    /**
     * 查询服务类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('support:type:list')")
    @GetMapping("/list")
    public AjaxResult list(EsServiceType esServiceType)
    {
        List<EsServiceType> list = esServiceTypeService.selectEsServiceTypeList(esServiceType);
        return success(list);
    }

    /**
     * 导出服务类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('support:type:export')")
    @Log(title = "服务类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsServiceType esServiceType)
    {
        List<EsServiceType> list = esServiceTypeService.selectEsServiceTypeList(esServiceType);
        ExcelUtil<EsServiceType> util = new ExcelUtil<EsServiceType>(EsServiceType.class);
        util.exportExcel(response, list, "服务类型管理数据");
    }

    /**
     * 获取服务类型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('support:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esServiceTypeService.selectEsServiceTypeById(id));
    }

    /**
     * 新增服务类型管理
     */
    @PreAuthorize("@ss.hasPermi('support:type:add')")
    @Log(title = "服务类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsServiceType esServiceType)
    {
        return toAjax(esServiceTypeService.insertEsServiceType(esServiceType));
    }

    /**
     * 修改服务类型管理
     */
    @PreAuthorize("@ss.hasPermi('support:type:edit')")
    @Log(title = "服务类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsServiceType esServiceType)
    {
        return toAjax(esServiceTypeService.updateEsServiceType(esServiceType));
    }

    /**
     * 删除服务类型管理
     */
    @PreAuthorize("@ss.hasPermi('support:type:remove')")
    @Log(title = "服务类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esServiceTypeService.deleteEsServiceTypeByIds(ids));
    }
}
