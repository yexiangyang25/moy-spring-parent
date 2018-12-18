package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.beans.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [异常 测试]</p>
 * Created on 2018/12/18
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class ExceptionController {

    @RequestMapping(value = "/exception/404", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<String> login() {
        if (true) {
            throw new NullPointerException();
        }
        return ResultBean.success();
    }
}
