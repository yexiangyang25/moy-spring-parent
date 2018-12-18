package org.moy.spring.test.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <p>Description: [全局 异常通知]</p>
 * Created on 2018/12/18
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Aspect
@Component
public class ExceptionHandlerAspect {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Pointcut("execution (public org.moy.spring.test.example.beans.ResultBean org.moy.spring.test.example.controller.*.*(..))")
    private void aspectMethod() {
    }

    @Around(value = "aspectMethod()")
    public Object around(ProceedingJoinPoint point) {
        ResultBean<?> result = null;
        try {
            result = (ResultBean<?>) point.proceed();
        } catch (Throwable ex) {
            LOG.error("统一结果拦截器拦截异常", ex);
            return ResultBean.fail(ex.getMessage());
        }
        return result;
    }

    @Pointcut("execution (public org.moy.spring.test.example.beans.PageResultBean org.moy.spring.test.example.controller.*.*(..))")
    private void aspectPageMethod() {
    }

    @Around(value = "aspectPageMethod()")
    public Object pageAround(ProceedingJoinPoint point) {
        PageResultBean<?> result = null;
        try {
            result = (PageResultBean<?>) point.proceed();
        } catch (Throwable ex) {
            LOG.error("统一结果拦截器拦截异常", ex);
            return PageResultBean.fail(ex.getMessage());
        }
        return result;
    }
}
