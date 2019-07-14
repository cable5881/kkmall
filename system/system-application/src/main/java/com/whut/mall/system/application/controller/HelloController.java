package com.whut.mall.system.application.controller;

import com.whut.mall.common.framework.vo.CommonResult;
import com.whut.mall.system.api.HelloService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Hello模块")
public class HelloController {

    @Reference(validation = "true", version = "${dubbo.provider.HelloService.version}")
    private HelloService helloService;

    @GetMapping("/hello")
    public CommonResult hello(String name) {
        return CommonResult.success(helloService.hello(name));
    }

    @GetMapping("/hello2")
    public CommonResult hello2(String name) {
        return CommonResult.success("hello world");
    }
}
