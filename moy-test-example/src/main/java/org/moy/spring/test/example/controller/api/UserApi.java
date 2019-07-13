package org.moy.spring.test.example.controller.api;


import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.moy.jwt.shiro.UserAuthInfo;
import org.moy.spring.common.*;
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
     *
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/user/info", method = {RequestMethod.POST})
    ResultBean<UserAuthInfo> info();

    /**
     * 测试权限
     *
     * @return
     */
    @RequiresPermissions("auth")
    @RequestMapping(value = "/user/auth", method = {RequestMethod.POST})
    ResultBean<UserDTO> infoAuth();

    /**
     * 测试角色
     *
     * @return
     */
    @RequiresRoles("role")
    @RequestMapping(value = "/user/role", method = {RequestMethod.POST})
    ResultBean<UserDTO> infoRole();


    /**
     * 查询所有用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/user/findAll", method = {RequestMethod.POST})
    PageResultBean<List<UserDTO>> findAll(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize);
}
