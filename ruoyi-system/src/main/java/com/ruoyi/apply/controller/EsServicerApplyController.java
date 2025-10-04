package com.ruoyi.apply.controller;

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
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.apply.domain.EsServicerApply;
import com.ruoyi.apply.service.IEsServicerApplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务主体审核Controller
 * 
 * @author ruoyi
 * @date 2025-09-25
 */
@RestController
@RequestMapping("/apply/process")
public class EsServicerApplyController extends BaseController
{
    @Autowired
    private IEsServicerApplyService esServicerApplyService;

    /**
     * 查询服务主体审核列表
     */
    @PreAuthorize("@ss.hasPermi('apply:process:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsServicerApply esServicerApply)
    {
        startPage();
        List<EsServicerApply> list = esServicerApplyService.selectEsServicerApplyList(esServicerApply);
        return getDataTable(list);
    }

    /**
     * 导出服务主体审核列表
     */
    @PreAuthorize("@ss.hasPermi('apply:process:export')")
    @Log(title = "服务主体审核", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsServicerApply esServicerApply)
    {
        List<EsServicerApply> list = esServicerApplyService.selectEsServicerApplyList(esServicerApply);
        ExcelUtil<EsServicerApply> util = new ExcelUtil<EsServicerApply>(EsServicerApply.class);
        util.exportExcel(response, list, "服务主体审核数据");
    }

    /**
     * 获取服务主体审核详细信息
     */
    @PreAuthorize("@ss.hasPermi('apply:process:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esServicerApplyService.selectEsServicerApplyById(id));
    }

    /**
     * 新增服务主体审核
     */
    @PreAuthorize("@ss.hasPermi('apply:process:add')")
    @Log(title = "服务主体审核", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsServicerApply esServicerApply)
    {
        // 强制绑定申请人为当前用户，防止越权
        esServicerApply.setApplyUserId(SecurityUtils.getUserId());
        return toAjax(esServicerApplyService.insertEsServicerApply(esServicerApply));
    }

    /**
     * 修改服务主体审核
     */
    @PreAuthorize("@ss.hasPermi('apply:process:edit')")
    @Log(title = "服务主体审核", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsServicerApply esServicerApply)
    {
        // 仅创建者或管理员可编辑
        Long currentUserId = SecurityUtils.getUserId();
        if (!esServicerApplyService.canEdit(esServicerApply.getId(), currentUserId))
        {
            return AjaxResult.error("无权限编辑该申请");
        }
        return toAjax(esServicerApplyService.updateEsServicerApply(esServicerApply));
    }

    /**
     * 我的申请：当前用户的申请列表
     */
    @GetMapping("/my")
    public TableDataInfo my()
    {
        startPage();
        EsServicerApply param = new EsServicerApply();
        param.setApplyUserId(SecurityUtils.getUserId());
        return getDataTable(esServicerApplyService.selectEsServicerApplyList(param));
    }

    /**
     * 审核通过：写入主体，更新申请状态
     */
    @PreAuthorize("@ss.hasPermi('apply:process:approve')")
    @Log(title = "服务主体审核", businessType = BusinessType.UPDATE)
    @PostMapping("/approve/{id}")
    @Transactional
    public AjaxResult approve(@PathVariable("id") Long id)
    {
        return toAjax(esServicerApplyService.approveServicerApply(id, SecurityUtils.getUserId()));
    }

    /**
     * 审核驳回：仅更新申请状态
     */
    @PreAuthorize("@ss.hasPermi('apply:process:reject')")
    @Log(title = "服务主体审核", businessType = BusinessType.UPDATE)
    @PostMapping("/reject/{id}")
    @Transactional
    public AjaxResult reject(@PathVariable("id") Long id, @RequestBody(required = false) EsServicerApply payload)
    {
        String remark = payload != null ? payload.getAuditRemark() : null;
        return toAjax(esServicerApplyService.rejectServicerApply(id, SecurityUtils.getUserId(), remark));
    }

    /**
     * 删除服务主体审核
     */
    @PreAuthorize("@ss.hasPermi('apply:process:remove')")
    @Log(title = "服务主体审核", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esServicerApplyService.deleteEsServicerApplyByIds(ids));
    }
}
