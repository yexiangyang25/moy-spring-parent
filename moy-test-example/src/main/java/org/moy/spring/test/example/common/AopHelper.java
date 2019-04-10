package org.moy.spring.test.example.common;

import org.apache.commons.lang3.reflect.MethodUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Description: [aop 帮助类]</p>
 * Created on 2018/7/5
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class AopHelper {

    private static final LocalVariableTableParameterNameDiscoverer PARAMETER_NAME_DISCOVERER = new LocalVariableTableParameterNameDiscoverer();

    private AopHelper() {
    }

    /**
     * 获取类上指定注解
     *
     * @param joinPoint
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Annotation> T getAnnotationOfMethod(JoinPoint joinPoint, Class<T> clazz) {
        T annotation = null;
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            try {
                Method subMethod = joinPoint.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
                annotation = MethodUtils.getAnnotation(subMethod, clazz, true, false);
                return null != annotation ? annotation : MethodUtils.getAnnotation(method, clazz, true, false);
            } catch (NoSuchMethodException e) {
                // do nothing
            }
        }
        return null;
    }

    /**
     * 获取方法参数和实际传参值的键值对
     *
     * @param joinPoint
     * @return
     */
    public static Map<String, Object> getParameterPairOfMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            String[] parameterNames = null;
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            try {
                Method subMethod = joinPoint.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
                parameterNames = getParameterNamesOfMethod(subMethod);
                parameterNames = null != parameterNames ? parameterNames : getParameterNamesOfMethod(method);
            } catch (NoSuchMethodException e) {
                // do nothing
            }
            Object[] args = joinPoint.getArgs();
            if (null != parameterNames && null != args
                    && parameterNames.length == args.length) {
                Map<String, Object> hashMap = new LinkedHashMap<>(parameterNames.length);
                for (int i = 0; i < parameterNames.length; i++) {
                    hashMap.put(parameterNames[i], args[i]);
                }
                return hashMap;
            }
        }
        return null;
    }

    /**
     * 获取实际方法参数定义数组
     *
     * @param joinPoint
     * @return
     */
    public static String[] getParameterNamesOfMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            return getParameterNamesOfMethod(method);
        }
        return null;
    }

    /**
     * 获取实际方法参数定义数组
     *
     * @param method
     * @return
     */
    public static String[] getParameterNamesOfMethod(Method method) {
        if (null != method) {
            return PARAMETER_NAME_DISCOVERER.getParameterNames(method);
        } else {
            return null;
        }
    }
}
