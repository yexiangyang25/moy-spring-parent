package org.moy.spring.test.example.service;

import org.moy.spring.test.example.common.BaseTemplateService;
import org.moy.spring.test.example.domain.RolePermissionEntity;

import java.util.List;

/**
 * <p>Description: [角色权限关系 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface RolePermissionService extends BaseTemplateService<RolePermissionEntity, Long> {

    /**
     * 根据编码查询
     * @param roleCode
     * @return
     */
    List<RolePermissionEntity> queryByRoleCode(String roleCode);

}
