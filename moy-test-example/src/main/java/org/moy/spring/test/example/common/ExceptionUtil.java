package org.moy.spring.test.example.common;

/**
 * <p>Description: [基础异常工具类]</p>
 * Created on 2019/05/04
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ExceptionUtil {

    private ExceptionUtil() {
    }

    public static BusinessException newBusinessException(String msg) {
        throw new BusinessException(msg);
    }

    public static BusinessException newBusinessException(Integer code, String msg) {
        throw new BusinessException(code, msg);
    }
}
