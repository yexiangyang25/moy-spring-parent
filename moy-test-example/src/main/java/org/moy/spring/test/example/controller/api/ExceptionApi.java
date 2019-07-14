package org.moy.spring.test.example.controller.api;


import org.moy.spring.common.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>Description: [异常 REST API]</p>
 * Created on 2018/12/13
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface ExceptionApi {

    /**
     * 测试aop异常
     * @return
     */
    @RequestMapping(value = "/exception/result", method = {RequestMethod.POST})
    ResultBean<String> exceptionResult();

    /**
     * 测试aop异常
     * @return
     */
    @RequestMapping(value = "/exception/page", method = {RequestMethod.POST})
    PageResultBean<List<String>> exceptionPage();
}
