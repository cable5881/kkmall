package com.whut.mall.system.api.dto.admin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@ApiModel("管理员认证 DTO")
@Data
@Accessors(chain = true)
public class AdminAuthenticationDTO {

    @ApiModelProperty(value = "登录账号",required = true,example = "17625019930")
    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 5,max =16,message = "账号长度为5-16位")
    @Pattern(regexp = "^[A-Za-z0-9]+$",message = "账号格式为数字以及字母")
    private String username;

    @ApiModelProperty(value = "密码",required = true,example = "xiaodao6666")
    @NotEmpty(message = "密码不能为空")
    @Length(min=4,max=16,message = "密码长度为4-16位")
    private String password;
}
