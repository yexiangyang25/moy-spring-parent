package org.moy.spring.test.example.adapter.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.moy.spring.test.example.adapter.service.LoginAdapterService;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseService;
import org.moy.spring.test.example.common.ExceptionUtil;
import org.moy.spring.test.example.common.NullUtil;
import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.service.PasswordService;
import org.moy.spring.test.example.service.UserService;
import org.moy.spring.test.example.shiro.JwtCacheManager;
import org.moy.spring.test.example.shiro.JwtSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * <p>Description: [登录 适配接口实现]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class LoginAdapterServiceImpl extends BaseService implements LoginAdapterService {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private JwtCacheManager jwtCacheManager;

    @Override
    public ResultBean<String> login(String username, String password) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            UserEntity userEntity = userService.queryByUsername(username);
            if (NullUtil.objectIsNotNull(userEntity)) {
                if (passwordService.checkUserCodeAndPasswordIsOk(userEntity.getCode(), password)) {
                    HashMap<String, String> hashMap = new HashMap<>(2);
                    hashMap.put(JwtSecurityUtils.USERNAME, userEntity.getName());
                    String token = jwtCacheManager.saveToken(userEntity.getCode(), hashMap);
                    return ResultBean.success(token);
                }
            }
        }
        throw ExceptionUtil.newBusinessException("account not exist!");
    }

    @Override
    public ResultBean<Boolean> logout() {
        Boolean deleteToken = jwtCacheManager.deleteToken(JwtSecurityUtils.getCurrentPrincipal());
        return ResultBean.success(deleteToken);
    }
}
