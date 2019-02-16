package org.moy.spring.test.example.adapter.service.impl;

import org.moy.spring.test.example.adapter.service.InitAdapterService;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: [初始化数据 适配接口实现]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class InitAdapterServiceImpl implements InitAdapterService {

    @Autowired
    private InitService initService;

    @Override
    public ResultBean<Boolean> initAdmin() {
        return ResultBean.success(initService.insertInitAdmin());
    }
}
