package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.domain.RolePermissionEntity;
import org.moy.spring.test.example.repository.RolePermissionRepository;
import org.moy.spring.test.example.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>Description: [角色权限关系 接口实现]</p>
 * Created on 2018/12/30
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class RolePermissionServiceImpl extends BaseTemplateServiceImpl<RolePermissionRepository, RolePermissionEntity, Long> implements RolePermissionService {
}
