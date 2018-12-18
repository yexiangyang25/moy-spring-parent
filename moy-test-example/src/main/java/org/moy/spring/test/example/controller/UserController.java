package org.moy.spring.test.example.controller;


import org.moy.spring.test.example.adapter.service.UserAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class UserController extends BaseController {

    @Autowired
    private UserAdapterService userAdapterService;

    @RequestMapping(value = "/user/info", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<UserDTO> info() {
        return ResultBean.success();
    }


    @RequestMapping(value = "/user/findAll", method = {RequestMethod.GET, RequestMethod.POST})
    public PageResultBean<List<UserDTO>> findAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return userAdapterService.findAll(pageNum, pageSize);
    }
}
