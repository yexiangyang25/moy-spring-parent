package org.moy.spring.test.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
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

    @Pointcut("execution (* org.moy.spring.test.example.controller.*.*(..))")
    private void aspectjMethod() {
    }

    @AfterThrowing(value = "aspectjMethod()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        LOG.error("异常拦截器拦截异常", e);
    }

    @Around(value = "aspectjMethod()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable ex) {
            LOG.error("统一结果拦截器拦截异常", ex);
            return result;
        }
        return result;
    }
}
