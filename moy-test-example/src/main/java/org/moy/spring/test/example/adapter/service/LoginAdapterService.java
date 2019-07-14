package org.moy.spring.test.example.adapter.service;


import org.moy.spring.common.*;

/**
 * <p>Description: [登录 适配接口]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface LoginAdapterService {


    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    ResultBean<String> login(String username, String password);

    /**
     * 登出
     * @return
     */
    ResultBean<Boolean> logout();
}
