package com.ruoyi.apply.mapper;

import java.util.List;
import com.ruoyi.apply.domain.EsServicerApply;

/**
 * 服务主体审核Mapper接口
 * 
 * @author ruoyi
 * @date 2025-09-25
 */
public interface EsServicerApplyMapper 
{
    /**
     * 查询服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 服务主体审核
     */
    public EsServicerApply selectEsServicerApplyById(Long id);

    /**
     * 查询服务主体审核列表
     * 
     * @param esServicerApply 服务主体审核
     * @return 服务主体审核集合
     */
    public List<EsServicerApply> selectEsServicerApplyList(EsServicerApply esServicerApply);

    /**
     * 新增服务主体审核
     * 
     * @param esServicerApply 服务主体审核
     * @return 结果
     */
    public int insertEsServicerApply(EsServicerApply esServicerApply);

    /**
     * 修改服务主体审核
     * 
     * @param esServicerApply 服务主体审核
     * @return 结果
     */
    public int updateEsServicerApply(EsServicerApply esServicerApply);

    /**
     * 删除服务主体审核
     * 
     * @param id 服务主体审核主键
     * @return 结果
     */
    public int deleteEsServicerApplyById(Long id);

    /**
     * 批量删除服务主体审核
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEsServicerApplyByIds(Long[] ids);
}
