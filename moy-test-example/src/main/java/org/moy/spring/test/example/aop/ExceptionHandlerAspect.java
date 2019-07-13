package org.moy.spring.test.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.moy.spring.common.*;
import org.moy.spring.test.example.validator.I18nComponent;
import org.moy.spring.test.example.validator.ValidatorResult;
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

    @Pointcut("execution (public org.moy.spring.common.ResultBean org.moy.spring.test.example.controller.*.*(org.moy.spring.common.RequestBean))")
    private void aspectMethod() {
    }

    @Pointcut("execution (public org.moy.spring.common.PageResultBean org.moy.spring.test.example.controller.*.*(org.moy.spring.common.RequestBean))")
    private void aspectPageMethod() {
    }


    @Around(value = "aspectMethod()")
    public Object around(ProceedingJoinPoint point) {
        ApiLogRecord logRecord = ApiLogRecord.buildCallBefore(point);

        ResultBean<?> result = null;
        try {
            validatorRequest(point);
            result = (ResultBean<?>) point.proceed();
        } catch (Throwable ex) {
            LOG.error("分页统一拦截器拦截业务异常", ex);
            if (ex instanceof BaseException) {
                BaseException e = (BaseException) ex;
                result = ResultBean.fail(e.getCode(), e.getMsg());
            } else {
                result = ResultBean.newFriendResult();
            }
        }

        ApiLogRecord.buildCallAfter(logRecord, result);
        return result;
    }

    @Around(value = "aspectPageMethod()")
    public Object pageAround(ProceedingJoinPoint point) {
        ApiLogRecord logRecord = ApiLogRecord.buildCallBefore(point);

        PageResultBean<?> result = null;
        try {
            validatorRequest(point);
            result = (PageResultBean<?>) point.proceed();
        } catch (Throwable ex) {
            LOG.error("分页统一拦截器拦截业务异常", ex);
            if (ex instanceof BaseException) {
                BaseException e = (BaseException) ex;
                result = PageResultBean.fail(e.getCode(), e.getMsg());
            } else {
                result = PageResultBean.newFriendPageResult();
            }
        }

        ApiLogRecord.buildCallAfter(logRecord, result);
        return result;
    }

    private void validatorRequest(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        if (null != args) {
            for (Object o : args) {
                ValidatorResult<Object> validateResult = i18nComponent.getValidateResult(o);
                if (validateResult.validatorIsNotOk()) {
                    ExceptionUtil.newBusinessException(validateResult.getErrorMessage());
                }
            }
        }
    }
}
