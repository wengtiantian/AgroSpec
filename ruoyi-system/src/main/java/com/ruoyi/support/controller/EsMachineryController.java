package com.ruoyi.support.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.subject.domain.EsServicer;
import com.ruoyi.subject.service.IEsServicerService;
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
import com.ruoyi.support.domain.EsMachinery;
import com.ruoyi.support.service.IEsMachineryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 农机Controller
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
@RestController
@RequestMapping("/support/machinery")
public class EsMachineryController extends BaseController
{
    @Autowired
    private IEsMachineryService esMachineryService;
    @Autowired
    private IEsServicerService esServicerService;
    /**
     * 查询农机列表
     */
    @PreAuthorize("@ss.hasPermi('support:machinery:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsMachinery esMachinery)
    {
        startPage();
        List<EsMachinery> list = esMachineryService.selectEsMachineryList(esMachinery);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasRole('servicer')")
    @GetMapping("/listAll")
    public AjaxResult list()
    {
        EsMachinery esMachinery = new EsMachinery();
        esMachinery.setServiceSubjectId(esServicerService.selectEsServicerByUserId(getUserId()).getId());
        List<EsMachinery> list = esMachineryService.selectEsMachineryList(esMachinery);
        return success(list);
    }

    /**
     * 导出农机列表
     */
    @PreAuthorize("@ss.hasPermi('support:machinery:export')")
    @Log(title = "农机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsMachinery esMachinery)
    {
        List<EsMachinery> list = esMachineryService.selectEsMachineryList(esMachinery);
        ExcelUtil<EsMachinery> util = new ExcelUtil<EsMachinery>(EsMachinery.class);
        util.exportExcel(response, list, "农机数据");
    }

    /**
     * 获取农机详细信息
     */
    @PreAuthorize("@ss.hasPermi('support:machinery:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esMachineryService.selectEsMachineryById(id));
    }

    /**
     * 新增农机
     */
    @PreAuthorize("@ss.hasPermi('support:machinery:add')")
    @Log(title = "农机", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsMachinery esMachinery)
    {
        return toAjax(esMachineryService.insertEsMachinery(esMachinery));
    }


    /**
     * 新增农机
     */
    @PreAuthorize("@ss.hasRole('servicer')")
    @Log(title = "农机", businessType = BusinessType.INSERT)
    @PostMapping("/addByService")
    public AjaxResult addByServicer(@RequestBody EsMachinery esMachinery)
    {

        EsServicer esServicer = esServicerService.selectEsServicerByUserId(getUserId());
        esMachinery.setServiceSubjectId(esServicer.getId());
        return toAjax(esMachineryService.insertEsMachinery(esMachinery));
    }

    /**
     * 修改农机
     */
    @PreAuthorize("@ss.hasPermi('support:machinery:edit')")
    @Log(title = "农机", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsMachinery esMachinery)
    {
        return toAjax(esMachineryService.updateEsMachinery(esMachinery));
    }

    /**
     * 删除农机
     */
    @PreAuthorize("@ss.hasPermi('support:machinery:remove')")
    @Log(title = "农机", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esMachineryService.deleteEsMachineryByIds(ids));
    }


    /**
     * 删除农机
     */
    @PreAuthorize("@ss.hasRole('servicer')")
    @Log(title = "农机", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(esMachineryService.deleteEsMachineryById(id));
    }
}
