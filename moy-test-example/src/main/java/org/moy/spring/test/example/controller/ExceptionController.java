package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping(value = "/exception/result", method = {RequestMethod.GET, RequestMethod.POST})
    public ResultBean<String> exceptionResult() {
        if (true) {
            int i = 1 / 0;
        }
        return ResultBean.success();
    }

    @RequestMapping(value = "/exception/page", method = {RequestMethod.GET, RequestMethod.POST})
    public PageResultBean<List<String>> exceptionPage() {
        if (true) {
            int i = 1 / 0;
        }
        return new PageResultBean<>();
    }
}
