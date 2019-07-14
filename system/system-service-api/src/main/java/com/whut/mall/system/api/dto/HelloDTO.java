package com.whut.mall.system.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@ApiModel("Hello DTO")
@Data
@Accessors(chain = true)
public class HelloDTO {

    @ApiModelProperty(value = "名称", required = true, example = "小王")
    @NotEmpty(message = "名称不能为空")
    @Length(max = 10, message = "昵称长度最大为 10 位")
    private String name;

}
