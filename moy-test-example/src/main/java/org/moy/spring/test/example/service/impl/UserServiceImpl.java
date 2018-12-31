package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.common.NullUtil;
import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.repository.UserRepository;
import org.moy.spring.test.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: [用户 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class UserServiceImpl extends BaseTemplateServiceImpl<UserRepository, UserEntity, Long> implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity queryByUsername(String username) {
        UserEntity entity = new UserEntity();
        entity.setName(username);
        List<UserEntity> queryResult = userRepository.query(entity);

        if (NullUtil.collectionIsNotEmpty(queryResult)) {
            int size = queryResult.size();
            if (1 == size) {
                return queryResult.get(0);
            }
            LOG.error("用户名称为{},查询出{}条记录,查询结果返回null", username, size);
        }
        LOG.warn("没有查询到用户名称为{}", username);
        return null;
    }
}
