package org.moy.spring.test.example.controller.api;

import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.LoginDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<String> login(@RequestBody RequestBean<LoginDTO> requestBean);

    /**
     * 登出
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<Boolean> logout(@RequestBody RequestBean<Object> requestBean);
}
