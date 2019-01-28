package org.moy.spring.test.example.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>Description: [反射 帮助类]</p>
 * Created on 2018/7/5
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ReflectUtil {

    private ReflectUtil() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<?> clazz) {
        try {
            return (T) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("new instance failure!", e);
        }
    }

    public static Object invokeMethod(Object obj, Method method, Object... args) {
        method.setAccessible(true);
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException("invoke method failure!", e);
        }
    }

    public static void setFieldValue(Object obj, Field field, Object value) {
        field.setAccessible(true);
        try {
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException("set field value failure!", e);
        }
    }
}
