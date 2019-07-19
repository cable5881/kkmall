package com.whut.mall.system.service;

import com.whut.mall.system.api.OAuth2Service;
import com.whut.mall.system.api.bo.oauth2.OAuth2AccessTokenBO;
import com.whut.mall.system.api.dto.oauth2.OAuth2CreateTokenDTO;
import com.whut.mall.system.convert.OAuth2Convert;
import com.whut.mall.system.dao.OAuth2AccessTokenMapper;
import com.whut.mall.system.dao.OAuth2RefreshTokenMapper;
import com.whut.mall.system.dataobject.OAuth2AccessTokenDO;
import com.whut.mall.system.dataobject.OAuth2RefreshTokenDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.OAuth2Service.version:1.0.0}")
public class OAuth2ServiceImpl implements OAuth2Service {

    /**
     * 访问令牌过期时间，单位：毫秒
     */
    @Value("${modules.oauth2-code-service.access-token-expire-time-millis}")
    private int accessTokenExpireTimeMillis;
    /**
     * 刷新令牌过期时间，单位：毫秒
     */
    @Value("${modules.oauth2-code-service.refresh-token-expire-time-millis}")
    private int refreshTokenExpireTimeMillis;

    @Autowired
    private OAuth2AccessTokenMapper oauth2AccessTokenMapper;
    @Autowired
    private OAuth2RefreshTokenMapper oauth2RefreshTokenMapper;

    @Override
    @Transactional
    public OAuth2AccessTokenBO createToken(OAuth2CreateTokenDTO oauth2CreateTokenDTO) {
        Integer userId = oauth2CreateTokenDTO.getUserId();
        Integer userType = oauth2CreateTokenDTO.getUserType();
        // 创建刷新令牌
        OAuth2RefreshTokenDO oauth2RefreshTokenDO = createOAuth2RefreshToken(userId, userType);
        // 创建访问令牌
        OAuth2AccessTokenDO oauth2AccessTokenDO = createOAuth2AccessToken(userId, userType, oauth2RefreshTokenDO.getId());
        // 转换返回
        return OAuth2Convert.INSTANCE.convertToAccessTokenWithExpiresIn(oauth2AccessTokenDO);
    }

    private OAuth2RefreshTokenDO createOAuth2RefreshToken(Integer userId, Integer userType) {
        OAuth2RefreshTokenDO refreshToken
                = new OAuth2RefreshTokenDO()
                .setId(generateRefreshToken())
                .setUserId(userId).setUserType(userType)
                .setExpiresTime(new Date(System.currentTimeMillis() + refreshTokenExpireTimeMillis))
                .setValid(true);
        oauth2RefreshTokenMapper.insert(refreshToken);
        return refreshToken;
    }

    private OAuth2AccessTokenDO createOAuth2AccessToken(Integer userId, Integer userType, String refreshToken) {
        OAuth2AccessTokenDO accessToken
                = new OAuth2AccessTokenDO()
                .setId(generateAccessToken())
                .setRefreshToken(refreshToken)
                .setUserId(userId).setUserType(userType)
                .setExpiresTime(new Date(System.currentTimeMillis() + accessTokenExpireTimeMillis))
                .setValid(true);
        oauth2AccessTokenMapper.insert(accessToken);
        return accessToken;
    }

    private String generateAccessToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String generateRefreshToken() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
