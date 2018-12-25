package org.moy.spring.test.example.controller;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>Description: [用户 REST API]</p>
 * Created on 2018/12/13
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface UserApi {

    /**
     * 用户信息
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/user/info", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<UserDTO> info();


    /**
     * 查询所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/user/findAll", method = {RequestMethod.GET, RequestMethod.POST})
    PageResultBean<List<UserDTO>> findAll(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize);
}
