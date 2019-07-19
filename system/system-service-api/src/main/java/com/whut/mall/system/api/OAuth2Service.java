package com.whut.mall.system.api;

import com.whut.mall.system.api.bo.oauth2.OAuth2AccessTokenBO;
import com.whut.mall.system.api.dto.oauth2.OAuth2CreateTokenDTO;

/**
 * Oauth2 服务接口
 */
public interface OAuth2Service {

    /**
     * 根据身份信息，创建 accessToken 信息
     *
     * @param oauth2CreateTokenDTO 身份信息 DTO
     * @return accessToken 信息
     */
    OAuth2AccessTokenBO createToken(OAuth2CreateTokenDTO oauth2CreateTokenDTO);
}
