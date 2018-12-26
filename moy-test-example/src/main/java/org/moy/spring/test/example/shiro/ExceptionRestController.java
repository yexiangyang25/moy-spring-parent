package org.moy.spring.test.example.shiro;


import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthorizedException;
import org.moy.spring.test.example.beans.ResultBean;
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
     * 捕捉shiro的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResultBean handle401(ShiroException e) {
        LOG.error("shiroException : {}", e.getMessage());
        return ResultBean.fail("shiroException");
    }

    /**
     * 捕捉UnauthorizedException
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResultBean handle401(UnauthorizedException e) {
        LOG.error("UnauthorizedException : {}", e.getMessage());
        return ResultBean.fail("UnauthorizedException");

    }

    /**
     * 捕捉其他所有异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean globalException(HttpServletRequest request, Throwable ex) {
        LOG.error("unknownException : {}", ex.getMessage());
        return ResultBean.fail("unknownException");
    }
}
