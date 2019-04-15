package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.shiro.JwtSecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [欢迎 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String hi() {
        return String.format("你好, %s!", JwtSecurityUtils.getCurrentUserName());
    }
}
