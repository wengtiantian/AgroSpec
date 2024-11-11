package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.EsServicer;
import com.ruoyi.system.domain.EsStandards;
import com.ruoyi.system.service.IEsServicerService;
import com.ruoyi.system.service.IEsStandardsService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: SocialService
 * @BelongsPackage: com.ruoyi.system.controller
 * @Author: wang
 * @CreateTime: 2024-09-23 10:50
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/public")
public class PublicController extends BaseController {
    @Autowired
    private IEsServicerService esServicerService;
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IEsStandardsService esStandardsService;

    @GetMapping("/servicer/list")
    public TableDataInfo list(EsServicer esServicer)
    {
        startPage();
        List<EsServicer> list = esServicerService.selectEsServicerList(esServicer);
        return getDataTable(list);
    }

    /**
     * 查询标准管理列表
     */
    @GetMapping("/standards/list")
    public TableDataInfo list(EsStandards esStandards)
    {
        startPage();
        List<EsStandards> list = esStandardsService.selectEsStandardsList(esStandards);
        return getDataTable(list);
    }


    /**
     * 获取服务主体详细信息
     */

    @GetMapping(value = "/servicer/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(esServicerService.selectEsServicerById(id));
    }

    /**
     * 获取标准管理详细信息
     */
    @GetMapping(value = "/standards/{id}")
    public AjaxResult getStandardInfo(@PathVariable("id") Long id)
    {
        return success(esStandardsService.selectEsStandardsById(id));
    }
}
