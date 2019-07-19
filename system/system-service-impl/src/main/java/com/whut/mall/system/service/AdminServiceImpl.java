package com.whut.mall.system.service;

import com.whut.mall.common.framework.constant.AdminErrorCodeEnum;
import com.whut.mall.common.framework.constant.CommonStatusEnum;
import com.whut.mall.common.framework.constant.UserTypeEnum;
import com.whut.mall.common.framework.util.ServiceExceptionUtil;
import com.whut.mall.system.api.AdminService;
import com.whut.mall.system.api.bo.admin.AdminAuthenticationBO;
import com.whut.mall.system.api.bo.oauth2.OAuth2AccessTokenBO;
import com.whut.mall.system.api.dto.admin.AdminAuthenticationDTO;
import com.whut.mall.system.api.dto.oauth2.OAuth2CreateTokenDTO;
import com.whut.mall.system.convert.AdminConvert;
import com.whut.mall.system.dao.AdminMapper;
import com.whut.mall.system.dataobject.AdminDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private OAuth2ServiceImpl oauth2Service;

    @Override
    public AdminAuthenticationBO authentication(AdminAuthenticationDTO adminAuthenticationDTO) {
        AdminDO admin = adminMapper.selctByUsername(adminAuthenticationDTO.getUsername());
        if(admin==null){
            //账号不存在
            throw ServiceExceptionUtil.exception(AdminErrorCodeEnum.ADMIN_USERNAME_NOT_REGISTERED.getCode());
        }

        // 密码不正确
        if (!encodePassword(adminAuthenticationDTO.getPassword()).equals(admin.getPassword())) {
            throw ServiceExceptionUtil.exception(AdminErrorCodeEnum.ADMIN_PASSWORD_ERROR.getCode());
        }

        // 账号被禁用
        if (CommonStatusEnum.DISABLE.getValue().equals(admin.getStatus())) {
            throw ServiceExceptionUtil.exception(AdminErrorCodeEnum.ADMIN_IS_DISABLE.getCode());
        }
        // 创建 accessToken
        OAuth2AccessTokenBO accessTokenBO = oauth2Service.createToken(new OAuth2CreateTokenDTO().setUserId(admin.getId())
                .setUserType(UserTypeEnum.ADMIN.getValue()));
        // 转换返回
        return AdminConvert.INSTANCE.convert2(admin).setToken(accessTokenBO);
    }

    private String encodePassword(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

}
