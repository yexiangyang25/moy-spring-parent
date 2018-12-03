package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.repository.UserRepository;
import org.moy.spring.test.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>Description: [用户 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class UserServiceImpl extends BaseTemplateServiceImpl<UserEntity, Long> implements UserService {

    @Resource
    private UserRepository userRepository;
}
