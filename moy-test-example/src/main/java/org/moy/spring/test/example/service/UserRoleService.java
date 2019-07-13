package org.moy.spring.test.example.service;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.UserRoleEntity;

import java.util.List;

/**
 * <p>Description: [用户角色关系 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface UserRoleService extends BaseTemplateService<UserRoleEntity, Long> {

    /**
     * 根据用户编码查询用户角色关系
     * @param userCode
     * @return
     */
    List<UserRoleEntity> queryByUserCode(String userCode);

}
