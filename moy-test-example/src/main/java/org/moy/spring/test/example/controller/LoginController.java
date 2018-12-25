package org.moy.spring.test.example.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.shiro.JwtUtil;
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

    @Override
    public ResultBean<String> login() {
        String password = "123";
        String username = "admin";
        String sign = JwtUtil.sign(username, password);
        int round = Math.round(1);
        LOG.warn("round = {}", round);
        if (round > 100) {
            throw new UnauthorizedException();
        }
        return ResultBean.success(sign);
    }

    @Override
    public ResultBean<String> unAuth() {
        return ResultBean.fail("401");
    }
}
