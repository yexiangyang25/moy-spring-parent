package org.moy.spring.test.example.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
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
    JwtCacheManager jwtCacheManager;
    @Override
    public ResultBean<String> login() {
        String password = "123";
        String username = "admin";
        String sign = JwtUtil.sign(username);
        int round = Math.round(1);
        int maxValue = 100;
        LOG.warn("round = {}", round);
        if (round > maxValue) {
            throw new UnauthorizedException();
        }
        jwtCacheManager.saveToken(sign);
        return ResultBean.success(sign);
    }

    @Override
    public ResultBean<String> unAuth() {
        return ResultBean.fail("401");
    }
}
