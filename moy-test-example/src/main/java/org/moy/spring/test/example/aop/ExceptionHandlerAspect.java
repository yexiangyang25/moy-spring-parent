package org.moy.spring.test.example.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private I18nComponent i18nComponent;

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Pointcut("execution (public org.moy.spring.test.example.beans.ResultBean org.moy.spring.test.example.controller.*.*(..))")
    private void aspectMethod() {
    }

    @Around(value = "aspectMethod()")
    public Object around(ProceedingJoinPoint point) {
        ResultBean<?> result = null;
        try {
            String validateMessage = i18nComponent.getValidateMessage(point.getArgs());
            if (StringUtils.isEmpty(validateMessage)) {
                result = (ResultBean<?>) point.proceed();
            } else {
                return ResultBean.fail(validateMessage);
            }
        } catch (Throwable ex) {
            LOG.error("分页统一拦截器拦截业务异常", ex);
            if (ex instanceof BaseException) {
                BaseException e = (BaseException) ex;
                return ResultBean.fail(e.getCode(), e.getMsg());
            } else {
                return ResultBean.newFirendResult();
            }
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
            String validateMessage = i18nComponent.getValidateMessage(point.getArgs());
            if (StringUtils.isEmpty(validateMessage)) {
                result = (PageResultBean<?>) point.proceed();
            } else {
                return ResultBean.fail(validateMessage);
            }
        } catch (Throwable ex) {
            LOG.error("分页统一拦截器拦截业务异常", ex);
            if (ex instanceof BaseException) {
                BaseException e = (BaseException) ex;
                return ResultBean.fail(e.getCode(), e.getMsg());
            } else {
                return ResultBean.newFirendResult();
            }
        }
        return result;
    }
}
