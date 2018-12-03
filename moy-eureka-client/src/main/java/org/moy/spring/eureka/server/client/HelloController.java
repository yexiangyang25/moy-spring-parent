package org.moy.spring.eureka.server.client;

import org.apache.commons.lang3.ArrayUtils;
import org.moy.spring.pojo.Demo;
import org.moy.spring.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description: [欢迎接口]</p>
 * Created on 2018/11/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class HelloController implements HelloService {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public String index() {
        List<String> services = discoveryClient.getServices();
        String description = discoveryClient.description();
        String result = description + " : " + ArrayUtils.toString(services);
        LOG.info(result);
        return result;
    }

    @Override
    public Demo demo(@RequestHeader("header") String header,
                     @RequestParam("param")  String param,
                     @RequestBody Demo demo) {
        LOG.info("header={} param={} demo{}", header, param, demo);
        return demo;
    }
}
