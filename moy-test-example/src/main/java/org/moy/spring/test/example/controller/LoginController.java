package org.moy.spring.test.example.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.moy.spring.test.example.adapter.service.LoginAdapterService;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.controller.api.LoginApi;
import org.moy.spring.test.example.shiro.JwtCacheManager;
import org.moy.spring.test.example.shiro.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [登录 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class LoginController extends BaseController implements LoginApi {

    @Autowired
    private LoginAdapterService loginAdapterService;

    @Override
    public ResultBean<String> login() {
        return loginAdapterService.login("admin", "123");
    }

    @Override
    public ResultBean<String> unAuth() {
        return ResultBean.fail("401");
    }
}
