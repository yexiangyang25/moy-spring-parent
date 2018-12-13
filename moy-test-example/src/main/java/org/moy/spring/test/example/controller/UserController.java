package org.moy.spring.test.example.controller;


import org.moy.spring.test.example.common.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [用户 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class UserController extends BaseController {

    @RequestMapping("/user/info")
    public String info() {
        return "[]";
    }
}
