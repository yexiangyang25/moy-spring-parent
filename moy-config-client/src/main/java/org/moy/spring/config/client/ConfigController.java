package org.moy.spring.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [读取配置]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class ConfigController {

    @Autowired
    private Environment environment;

    @Value("${config}")
    private String config;

    @RequestMapping("/config")
    public String config() {
        return config;
    }

    @RequestMapping("/api")
    public String api() {
        return environment.getProperty("config", "undefined");
    }
}
