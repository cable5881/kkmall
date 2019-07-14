package com.whut.mall.system.api.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel("Hello BO")
@Data
@Accessors(chain = true)
public class HelloBO {
    @ApiModelProperty(value = "昵称", required = true, example = "小王")
    private String name;
}
