package com.whut.mall.system.api;

import com.whut.mall.system.api.bo.admin.AdminAuthenticationBO;
import com.whut.mall.system.api.dto.admin.AdminAuthenticationDTO;

public interface AdminService {
    /**
     * 管理员认证。认证成功后，返回认证信息
     *
     * 实际上，就是用户名 + 密码登陆
     *
     * @param adminAuthenticationDTO 用户认证信息
     * @return 认证信息
     */
    public AdminAuthenticationBO authentication(AdminAuthenticationDTO adminAuthenticationDTO);
}
