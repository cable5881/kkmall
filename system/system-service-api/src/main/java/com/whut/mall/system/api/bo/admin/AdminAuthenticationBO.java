package com.whut.mall.system.api.bo.admin;

import com.whut.mall.system.api.bo.oauth2.OAuth2AccessTokenBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("管理员认证 BO")
@Data
@Accessors(chain = true)
public class AdminAuthenticationBO {
    @ApiModelProperty(value = "管理员编码",required = true,example = "1")
    private Integer id;

    @ApiModelProperty(value = "昵称" , required = true,example = "木可仓刀")
    private String nickname;

    private OAuth2AccessTokenBO token;
}
