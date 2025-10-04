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
import com.ruoyi.subject.domain.EsProducter;
import com.ruoyi.subject.service.IEsProducterService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产主体管理Controller
 * 
 * @author wangchuang
 * @date 2024-07-14
 */
@RestController
@RequestMapping("/subject/producter")
public class EsProducterController extends BaseController
{
    @Autowired
    private IEsProducterService esProducterService;

    /**
     * 查询生产主体管理列表
     */
    @PreAuthorize("@ss.hasPermi('subject:producter:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsProducter esProducter)
    {
        startPage();
        List<EsProducter> list = esProducterService.selectEsProducterList(esProducter);
        return getDataTable(list);
    }

    /**
     * 导出生产主体管理列表
     */
    @PreAuthorize("@ss.hasPermi('subject:producter:export')")
    @Log(title = "生产主体管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsProducter esProducter)
    {
        List<EsProducter> list = esProducterService.selectEsProducterList(esProducter);
        ExcelUtil<EsProducter> util = new ExcelUtil<EsProducter>(EsProducter.class);
        util.exportExcel(response, list, "生产主体管理数据");
    }

    /**
     * 获取生产主体管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('subject:producter:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esProducterService.selectEsProducterById(id));
    }

    /**
     * 新增生产主体管理
     */
    @PreAuthorize("@ss.hasPermi('subject:producter:add')")
    @Log(title = "生产主体管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsProducter esProducter)
    {
        return toAjax(esProducterService.insertEsProducter(esProducter));
    }

    /**
     * 修改生产主体管理
     */
    @PreAuthorize("@ss.hasPermi('subject:producter:edit')")
    @Log(title = "生产主体管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsProducter esProducter)
    {
        return toAjax(esProducterService.updateEsProducter(esProducter));
    }

    /**
     * 删除生产主体管理
     */
    @PreAuthorize("@ss.hasPermi('subject:producter:remove')")
    @Log(title = "生产主体管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esProducterService.deleteEsProducterByIds(ids));
    }
}
