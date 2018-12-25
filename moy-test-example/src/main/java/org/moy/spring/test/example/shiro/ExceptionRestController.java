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

@RestControllerAdvice
public class ExceptionRestController {

    private static Logger LOG = LoggerFactory.getLogger(ExceptionRestController.class);

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResultBean handle401(ShiroException e) {
        LOG.error("shiroException : {}", e.getMessage());
        return ResultBean.fail("shiroException");
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResultBean handle401(UnauthorizedException e) {
        LOG.error("UnauthorizedException : {}", e.getMessage());
        return ResultBean.fail("UnauthorizedException");

    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean globalException(HttpServletRequest request, Throwable ex) {
        LOG.error("unknownException : {}", ex.getMessage());
        return ResultBean.fail("unknownException");
    }
}
