package org.moy.spring.test.example.adapter.service;

import org.moy.spring.test.example.beans.ResultBean;

/**
 * <p>Description: [初始化 适配接口]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface InitAdapterService {


    /**
     * 初始化管理员账号
     *
     * @return
     */
    ResultBean<Boolean> initAdmin();
}
