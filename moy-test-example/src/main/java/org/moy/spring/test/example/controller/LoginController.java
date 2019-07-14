package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.adapter.service.LoginAdapterService;
import org.moy.spring.common.*;
import org.moy.spring.test.example.controller.api.LoginApi;
import org.moy.spring.test.example.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResultBean<String> login(@RequestBody RequestBean<LoginDTO> requestBean) {
        LoginDTO loginDTO = requestBean.getRequest();
        return loginAdapterService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @Override
    public ResultBean<Boolean> logout(@RequestBody RequestBean<Object> requestBean) {
        return loginAdapterService.logout();
    }
}
