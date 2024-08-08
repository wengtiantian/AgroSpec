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
import com.ruoyi.system.domain.EsAuditProcess;
import com.ruoyi.system.service.IEsAuditProcessService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务主体审核Controller
 * 
 * @author wangchuang
 * @date 2024-08-03
 */
@RestController
@RequestMapping("/system/process")
public class EsAuditProcessController extends BaseController
{
    @Autowired
    private IEsAuditProcessService esAuditProcessService;

    /**
     * 查询服务主体审核列表
     */
    @PreAuthorize("@ss.hasPermi('system:process:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsAuditProcess esAuditProcess)
    {
        startPage();
        List<EsAuditProcess> list = esAuditProcessService.selectEsAuditProcessList(esAuditProcess);
        return getDataTable(list);
    }

    /**
     * 查询服务主体审核列表
     */
    @PreAuthorize("@ss.hasRole('servicer')")
    @GetMapping("/listAll")
    public AjaxResult listAll(EsAuditProcess esAuditProcess)
    {

        List<EsAuditProcess> list = esAuditProcessService.selectEsAuditProcessList(esAuditProcess);
        return success(list);
    }

    /**
     * 导出服务主体审核列表
     */
    @PreAuthorize("@ss.hasPermi('system:process:export')")
    @Log(title = "服务主体审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsAuditProcess esAuditProcess)
    {
        List<EsAuditProcess> list = esAuditProcessService.selectEsAuditProcessList(esAuditProcess);
        ExcelUtil<EsAuditProcess> util = new ExcelUtil<EsAuditProcess>(EsAuditProcess.class);
        util.exportExcel(response, list, "服务主体审核数据");
    }

    /**
     * 获取服务主体审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:process:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esAuditProcessService.selectEsAuditProcessById(id));
    }

    /**
     * 新增服务主体审核
     */
    @PreAuthorize("@ss.hasPermi('system:process:add')")
    @Log(title = "服务主体审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsAuditProcess esAuditProcess)
    {
        return toAjax(esAuditProcessService.insertEsAuditProcess(esAuditProcess));
    }

    /**
     * 新增服务主体审核
     */
    @PreAuthorize("@ss.hasRole('servicer')")
    @Log(title = "服务主体审核", businessType = BusinessType.INSERT)
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody EsAuditProcess esAuditProcess)
    {

        return toAjax(esAuditProcessService.insertEsAuditProcess(esAuditProcess));
    }


    /**
     * 修改服务主体审核
     */
    @PreAuthorize("@ss.hasPermi('system:process:edit')")
    @Log(title = "服务主体审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsAuditProcess esAuditProcess)
    {
        return toAjax(esAuditProcessService.updateEsAuditProcess(esAuditProcess));
    }




    /**
     * 删除服务主体审核
     */
    @PreAuthorize("@ss.hasPermi('system:process:remove')")
    @Log(title = "服务主体审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esAuditProcessService.deleteEsAuditProcessByIds(ids));
    }
}
