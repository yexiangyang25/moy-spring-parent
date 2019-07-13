package org.moy.spring.test.example.service.impl;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.UserRoleEntity;
import org.moy.spring.test.example.repository.UserRoleRepository;
import org.moy.spring.test.example.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: [用户角色关系 接口实现]</p>
 * Created on 2018/12/30
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class UserRoleServiceImpl extends BaseTemplateServiceImpl<UserRoleRepository, UserRoleEntity, Long> implements UserRoleService {
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public List<UserRoleEntity> queryByUserCode(String userCode) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserCode(userCode);
        return userRoleService.query(userRoleEntity);
    }
}
