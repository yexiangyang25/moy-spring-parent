package org.moy.spring.test.example.controller;


import org.moy.spring.test.example.adapter.service.UserAdapterService;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class UserController extends BaseController {

    @Autowired
    private UserAdapterService userAdapterService;

    @RequestMapping("/user/info")
    public String info() {
        return "[]";
    }


    @RequestMapping(value = "/user/findAll", method = {RequestMethod.GET, RequestMethod.POST})
    public List<UserDTO> findAll() {
        return userAdapterService.findAll();
    }
}
