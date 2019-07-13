package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.adapter.service.InitAdapterService;
import org.moy.spring.common.*;
import org.moy.spring.test.example.controller.api.InitApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [初始化 REST接口]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class InitController extends BaseController implements InitApi {

    @Autowired
    private InitAdapterService initAdapterService;

    @Override
    public ResultBean<Boolean> initAdmin() {
        return initAdapterService.initAdmin();
    }
}
