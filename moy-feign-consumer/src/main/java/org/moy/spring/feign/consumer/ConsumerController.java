package org.moy.spring.feign.consumer;

import org.moy.spring.pojo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    RefactorHelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.index();
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Demo demo() {
        Demo demo = new Demo();
        demo.setUsername("username");
        demo.setPassword("password");
        return helloService.demo("header", "param", demo);
    }
}
