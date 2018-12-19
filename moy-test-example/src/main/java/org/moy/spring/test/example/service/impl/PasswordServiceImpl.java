package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.domain.PasswordEntity;
import org.moy.spring.test.example.repository.PasswordRepository;
import org.moy.spring.test.example.service.PasswordService;
import org.springframework.stereotype.Service;

/**
 * <p>Description: [密码 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class PasswordServiceImpl extends BaseTemplateServiceImpl<PasswordRepository, PasswordEntity, Long> implements PasswordService {
}
