package org.moy.spring.feign.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.moy.spring.pojo.Demo;
import org.moy.spring.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [测试 rest接口]</p>
 * Created on 2018/12/02
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class ConsumerController {

    private static Logger LOG = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    RefactorHelloService helloService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return helloService.index();
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Demo demo() {
        Demo demo = new Demo();
        demo.setUsername("username");
        demo.setPassword("password");
        return helloService.demo("header", "param", demo);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "defaultTest")
    public String test() {
        if (true) {
            throw new NullPointerException();
        }
        return "test";
    }

    public String defaultTest() {
        LOG.error("服务熔断!!");
        return "default test";
    }
}
