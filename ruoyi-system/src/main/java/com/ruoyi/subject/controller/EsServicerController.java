package com.ruoyi.subject.controller;

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
import com.ruoyi.subject.domain.EsServicer;
import com.ruoyi.subject.domain.EsServicerStatusUpdate;
import com.ruoyi.subject.service.IEsServicerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务主体管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-10
 */
@RestController
@RequestMapping("/subject/servicer")
public class EsServicerController extends BaseController
{
    @Autowired
    private IEsServicerService esServicerService;

    /**
     * 查询服务主体管理列表
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsServicer esServicer)
    {
        startPage();
        List<EsServicer> list = esServicerService.selectEsServicerList(esServicer);
        return getDataTable(list);
    }

    /**
     * 导出服务主体管理列表
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:export')")
    @Log(title = "服务主体管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsServicer esServicer)
    {
        List<EsServicer> list = esServicerService.selectEsServicerList(esServicer);
        ExcelUtil<EsServicer> util = new ExcelUtil<EsServicer>(EsServicer.class);
        util.exportExcel(response, list, "服务主体管理数据");
    }

    /**
     * 获取服务主体管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esServicerService.selectEsServicerById(id));
    }

    /**
     * 新增服务主体管理
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:add')")
    @Log(title = "服务主体管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsServicer esServicer)
    {
        return toAjax(esServicerService.insertEsServicer(esServicer));
    }

    /**
     * 修改服务主体管理
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:edit')")
    @Log(title = "服务主体管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsServicer esServicer)
    {
        return toAjax(esServicerService.updateEsServicer(esServicer));
    }

    /**
     * 删除服务主体管理
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:remove')")
    @Log(title = "服务主体管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esServicerService.deleteEsServicerByIds(ids));
    }

    /**
     * 修改服务主体认证状态
     */
    @PreAuthorize("@ss.hasPermi('subject:servicer:edit')")
    @Log(title = "服务主体状态管理", businessType = BusinessType.UPDATE)
    @PutMapping("/editStatus")
    public AjaxResult editStatus(@RequestBody EsServicerStatusUpdate statusUpdate)
    {
        // 参数验证
        if (statusUpdate.getId() == null)
        {
            return AjaxResult.error("服务主体ID不能为空");
        }
        if (statusUpdate.getIsAuth() == null)
        {
            return AjaxResult.error("认证状态不能为空");
        }
        
        // 验证状态值是否有效
        if (statusUpdate.getIsAuth() < 0 || statusUpdate.getIsAuth() > 2)
        {
            return AjaxResult.error("认证状态值无效，应为0-2之间的整数");
        }
        
        return toAjax(esServicerService.updateEsServicerStatus(statusUpdate.getId(), statusUpdate.getIsAuth()));
    }
}
