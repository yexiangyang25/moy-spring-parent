package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.controller.api.ExceptionApi;
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
public class ExceptionController extends BaseController implements ExceptionApi {

    @Override
    public ResultBean<String> exceptionResult() {
        createException();
        return ResultBean.success();
    }

    private void createException() {
        if (true) {
            int i = 1 / 0;
        }
    }

    @Override
    public PageResultBean<List<String>> exceptionPage() {
        createException();
        return new PageResultBean<>();
    }
}
