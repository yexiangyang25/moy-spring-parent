package org.moy.spring.test.example.service;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.PasswordEntity;

/**
 * <p>Description: [密码 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface PasswordService extends BaseTemplateService<PasswordEntity, Long> {

    /**
     * 根据用户编码和密码校验
     * @param userCode
     * @param password
     * @return
     */
    Boolean checkUserCodeAndPasswordIsOk(String userCode , String password);
}
