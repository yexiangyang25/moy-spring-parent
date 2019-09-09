package org.moy.spring.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.moy.spring.dubbo.api.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description: [程序入口 注册中心]</p>
 * Created on 2018/11/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class DubboConsumerApplication {


    @Reference(version = "1.0.0")
    private HelloWorldService helloWorldService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @RequestMapping("/")
    public String sayHelloWorld() {
        return helloWorldService.sayHellWorld();
    }
}
