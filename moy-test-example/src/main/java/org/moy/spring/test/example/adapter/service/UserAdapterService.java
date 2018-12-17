package org.moy.spring.test.example.adapter.service;

import org.moy.spring.test.example.dto.UserDTO;

import java.util.List;

/**
 * <p>Description: [用户 适配接口]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface UserAdapterService {

    /**
     * 查询所有
     * @return
     */
    List<UserDTO> findAll();
}
