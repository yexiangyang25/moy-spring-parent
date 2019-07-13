package org.moy.spring.test.example.controller;

import org.moy.spring.common.*;
import org.moy.spring.test.example.controller.api.Swagger2Api;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [Swagger2 测试]</p>
 * Created on 2018/12/13
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class Swagger2Controller extends BaseController implements Swagger2Api {

    @Override
    public String sayHi(String name) {
        return "hi," + name;
    }
}
