package org.moy.spring.test.example.adapter.service;


import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.UserAuthInfoDTO;

/**
 * <p>Description: [用户权限信息 适配接口]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface UserAuthInfoAdapterService {


    /**
     * 根据用户名称查询权限名
     * @return
     */
    ResultBean<UserAuthInfoDTO> getCurrentUserInfo();
}
