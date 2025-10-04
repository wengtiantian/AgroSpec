package com.ruoyi.subject.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务主体状态更新对象
 * 
 * @author ruoyi
 */
public class EsServicerStatusUpdate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 服务主体ID */
    private Long id;

    /** 认证状态（0：未认证，1：等待审核，2：已认证） */
    private Integer isAuth;

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Integer getIsAuth() 
    {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) 
    {
        this.isAuth = isAuth;
    }

    @Override
    public String toString() 
    {
        return "EsServicerStatusUpdate{" +
                "id=" + id +
                ", isAuth=" + isAuth +
                '}';
    }
}
