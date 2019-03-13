package org.moy.spring.test.example.service.impl;


import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseEntityUtil;
import org.moy.spring.test.example.domain.PasswordEntity;
import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.domain.UserRoleEntity;
import org.moy.spring.test.example.service.InitService;
import org.moy.spring.test.example.service.PasswordService;
import org.moy.spring.test.example.service.UserRoleService;
import org.moy.spring.test.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Description: [初始化数据 接口实现]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private UserService userService;

    private final String ADMIN_ACCOUNT = "admin";
    private final String ADMIN_ACCOUNT_PASSWORD = "1111111";

    @Override
    public Boolean insertInitAdmin() {
        initAdminUser();
        initAdminPassword();
        initAdminRole();
        return true;
    }

    private void initAdminRole() {
        UserRoleEntity entity = new UserRoleEntity();
        entity.setRoleCode(ADMIN_ACCOUNT);
        entity.setUserCode(ADMIN_ACCOUNT);
        userRoleService.deleteByCondition(entity);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
        userRoleService.insert(entity);
    }

    private void initAdminPassword() {
        PasswordEntity entity = new PasswordEntity();
        entity.setCode(ADMIN_ACCOUNT_PASSWORD);
        entity.setUserCode(ADMIN_ACCOUNT);
        passwordService.deleteByCondition(entity);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
        passwordService.insert(entity);
    }

    private void initAdminUser() {
        UserEntity entity = new UserEntity();
        entity.setCode(ADMIN_ACCOUNT);
        userService.deleteByCondition(entity);
        entity.setName(ADMIN_ACCOUNT);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
        userService.insert(entity);
    }
}
