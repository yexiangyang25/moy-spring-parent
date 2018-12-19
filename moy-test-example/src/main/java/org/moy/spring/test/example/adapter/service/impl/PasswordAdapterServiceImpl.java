package org.moy.spring.test.example.adapter.service.impl;

import org.moy.spring.test.example.adapter.service.PasswordAdapterService;
import org.moy.spring.test.example.common.BaseService;
import org.moy.spring.test.example.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>Description: [密码 适配接口实现]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class PasswordAdapterServiceImpl extends BaseService implements PasswordAdapterService {

    @Autowired
    private PasswordService passwordService;

}
