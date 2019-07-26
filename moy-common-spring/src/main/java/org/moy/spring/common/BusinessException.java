package org.moy.spring.common;


/**
 * <p>Description: [基础异常]</p>
 * Created on 2019/05/04
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class BusinessException extends BaseException {

    private static final Integer BUSINESS_CODE = 1000;

    public BusinessException(String msg) {
        this(BUSINESS_CODE, msg);
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
