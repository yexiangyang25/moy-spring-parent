package org.moy.spring.test.example.shiro;


import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Description: [Rest 统一异常拦截]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestControllerAdvice
public class ExceptionRestController {

    private static Logger LOG = LoggerFactory.getLogger(ExceptionRestController.class);

    /**
     * 捕捉shiro的异常，定义http状态码为200
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ShiroException.class)
    public ResultBean handle401(HttpServletRequest request, ShiroException e) {
        LOG.warn("shiroException : {}", e.getMessage());
        return ResultBean.newNotLoginResult();
    }

    /**
     * 捕捉UnauthorizedException，定义http状态码为200
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(UnauthorizedException.class)
    public ResultBean handle401(UnauthorizedException e) {
        LOG.warn("UnauthorizedException : {}", e.getMessage());
        return ResultBean.newUnAuthResult();
    }

    /**
     * 捕捉其他所有异常，定义http状态码为200
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultBean globalException(HttpServletRequest request, Throwable ex) {
        LOG.error("unknownException", ex);
        if (ex instanceof BaseException) {
            BaseException e = (BaseException) ex;
            return ResultBean.fail(e.getCode(), e.getMsg());
        }
        String message = "系统开小差了，请稍候再试";
        return ResultBean.fail(message);
    }
}
