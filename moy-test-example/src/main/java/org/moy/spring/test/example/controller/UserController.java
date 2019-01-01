package org.moy.spring.test.example.controller;


import org.moy.spring.test.example.adapter.service.UserAdapterService;
import org.moy.spring.test.example.adapter.service.UserAuthInfoAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.controller.api.UserApi;
import org.moy.spring.test.example.dto.UserAuthInfoDTO;
import org.moy.spring.test.example.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description: [用户 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class UserController extends BaseController implements UserApi {

    @Autowired
    private UserAdapterService userAdapterService;
    @Autowired
    private UserAuthInfoAdapterService userAuthInfoAdapterService;

    @Override
    public ResultBean<UserAuthInfoDTO> info() {
        return userAuthInfoAdapterService.getCurrentUserInfo();
    }

    @Override
    public ResultBean<UserDTO> infoAuth() {
        return ResultBean.success("infoAuth",null);
    }

    @Override
    public ResultBean<UserDTO> infoRole() {
        return ResultBean.success("infoRole",null);
    }


    @Override
    public PageResultBean<List<UserDTO>> findAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return userAdapterService.findAll(pageNum, pageSize);
    }
}
