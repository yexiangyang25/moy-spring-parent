package org.moy.spring.service;

import org.moy.spring.pojo.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Description: [HelloService 服务降级默认实现]</p>
 * Created on 2018/12/04
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class HelloServiceDefaultFallback implements HelloService {

    private static Logger LOG = LoggerFactory.getLogger(HelloServiceDefaultFallback.class);

    @Override
    public String index() {
        LOG.error("服务熔断!!");
        return "";
    }

    @Override
    public Demo demo(String header, String param, Demo demo) {
        LOG.error("服务熔断!!");
        return new Demo();
    }
}
