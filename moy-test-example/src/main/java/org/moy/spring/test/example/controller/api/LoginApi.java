package org.moy.spring.test.example.controller.api;

import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.LoginDTO;
import org.moy.spring.test.example.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p>Description: [登录 REST API]</p>
 * Created on 2018/12/13
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface LoginApi {

    /**
     * 登录
     *
     * @param loginDTO
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<String> login(@RequestBody LoginDTO loginDTO);


    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<Boolean> logout();
}
