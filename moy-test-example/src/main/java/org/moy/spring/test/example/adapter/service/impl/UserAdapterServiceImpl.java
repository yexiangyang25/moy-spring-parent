package org.moy.spring.test.example.adapter.service.impl;

import org.moy.spring.test.example.adapter.service.UserAdapterService;
import org.moy.spring.test.example.common.BaseService;
import org.moy.spring.test.example.common.BeanHelper;
import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.dto.UserDTO;
import org.moy.spring.test.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: [用户 适配接口实现]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class UserAdapterServiceImpl extends BaseService implements UserAdapterService {

    @Autowired
    private UserService userService;

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> entityList = userService.findAll();
        List<UserDTO> dtoList = BeanHelper.copyList(entityList, UserDTO.class);
        return dtoList;
    }
}
