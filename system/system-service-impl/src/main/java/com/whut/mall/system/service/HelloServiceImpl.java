package com.whut.mall.system.service;

import com.whut.mall.system.api.HelloService;
import com.whut.mall.system.api.bo.HelloBO;
import org.springframework.stereotype.Service;

@Service
@org.apache.dubbo.config.annotation.Service(validation = "true", version = "${dubbo.provider.HelloService.version}")
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloBO hello(String name) {
        HelloBO helloBO = new HelloBO();
        helloBO.setName("Hello World");
        return helloBO;
    }
}
