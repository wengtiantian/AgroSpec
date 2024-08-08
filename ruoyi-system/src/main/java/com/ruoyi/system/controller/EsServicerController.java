package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.EsServicer;
import com.ruoyi.system.service.IEsServicerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 服务主体Controller
 * 
 * @author wangchuang
 * @date 2024-06-19
 */
@RestController
@RequestMapping("/system/servicer")
public class EsServicerController extends BaseController
{
    @Autowired
    private IEsServicerService esServicerService;
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询服务主体列表
     */
    @PreAuthorize("@ss.hasPermi('system:servicer:list')")
    @GetMapping("/list")
    public TableDataInfo list(EsServicer esServicer)
    {
        startPage();
        List<EsServicer> list = esServicerService.selectEsServicerList(esServicer);
        return getDataTable(list);
    }

    /**
     * 导出服务主体列表
     */
    @PreAuthorize("@ss.hasPermi('system:servicer:export')")
    @Log(title = "服务主体", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EsServicer esServicer)
    {
        List<EsServicer> list = esServicerService.selectEsServicerList(esServicer);
        ExcelUtil<EsServicer> util = new ExcelUtil<EsServicer>(EsServicer.class);
        util.exportExcel(response, list, "服务主体数据");
    }

    /**
     * 获取服务主体详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:servicer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esServicerService.selectEsServicerById(id));
    }

    /**
     * 新增服务主体
     */
    @PreAuthorize("@ss.hasPermi('system:servicer:add')")
    @Log(title = "服务主体", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EsServicer esServicer)
    {

        SysUser sysUser = new SysUser();
        sysUser.setUserName(esServicer.getAccountPhone());
        sysUser.setNickName(esServicer.getName());
        sysUser.setPassword(SecurityUtils.encryptPassword(("admin123")));
        sysUser.setPhonenumber(esServicer.getAccountPhone());
        sysUser.setRoleIds(new Long[]{100L});
        sysUser.setSex("0");
        sysUser.setStatus("0");
        sysUser.setCreateBy(getUsername());
        sysUserService.insertUser(sysUser);
        esServicer.setUserId(sysUser.getUserId());
        return toAjax(esServicerService.insertEsServicer(esServicer));
    }

    /**
     * 修改服务主体
     */
    @PreAuthorize("@ss.hasPermi('system:servicer:edit')")
    @Log(title = "服务主体", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EsServicer esServicer)
    {
        return toAjax(esServicerService.updateEsServicer(esServicer));
    }

    /**
     * 修改服务主体
     */
    @PreAuthorize("@ss.hasRole('servicer')")
    @Log(title = "服务主体", businessType = BusinessType.UPDATE)
    @PutMapping("/editStatus")
    public AjaxResult editStatus(@RequestBody EsServicer esServicer)
    {
        EsServicer esServicer1 = new EsServicer();
        esServicer1.setId(esServicer.getId());
        esServicer1.setIsAuth(esServicer.getIsAuth());
        return toAjax(esServicerService.updateEsServicer(esServicer1));
    }



    /**
     * 删除服务主体
     */
    @PreAuthorize("@ss.hasPermi('system:servicer:remove')")
    @Log(title = "服务主体", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(esServicerService.deleteEsServicerByIds(ids));
    }


    /**
     * 根据 user_id 查询服务主体
     *
     * @param userId 用户 ID
     * @return 服务主体列表
     */
    @PreAuthorize("@ss.hasPermi('servicer:profile')")
    @GetMapping("/user")
    public AjaxResult selectEsServicerByUserId() {
        EsServicer esServicer = esServicerService.selectEsServicerByUserId(getUserId());
        return AjaxResult.success(esServicer);
    }
}
