package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.domain.PermissionEntity;
import org.moy.spring.test.example.repository.PermissionRepository;
import org.moy.spring.test.example.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>Description: [权限 接口实现]</p>
 * Created on 2018/12/30
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class PermissionServiceImpl extends BaseTemplateServiceImpl<PermissionRepository, PermissionEntity, Long> implements PermissionService {
}
