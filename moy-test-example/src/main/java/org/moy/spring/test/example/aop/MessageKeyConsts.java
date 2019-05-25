package org.moy.spring.test.example.aop;

/**
 * <p>Description: [国际化 key]</p>
 * Created on 2019/5/24
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface MessageKeyConsts {

    String MESSAGE_LOGIN_USERNAME = "message.login.username";
    String MESSAGE_LOGIN_PASSWORD = "message.login.password";

    String MESSAGE_REQUEST_PAGE = "message.request.page";
    String MESSAGE_REQUEST_LIMIT = "message.request.limit";
    String MESSAGE_REQUEST_SOURCE = "message.request.source";
    String MESSAGE_REQUEST_REQUEST = "message.request.request";

    String MESSAGE_MAX = "message.max${value}";
}
