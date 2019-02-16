package org.moy.spring.test.example.controller.api;


import org.moy.spring.test.example.beans.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Description: [初始化 REST API]</p>
 * Created on 2019/1/16
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface InitApi {

    /**
     * 初始化管理员账号
     *
     * @return
     */
    @RequestMapping(value = "/initAdmin", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<Boolean> initAdmin();
}
