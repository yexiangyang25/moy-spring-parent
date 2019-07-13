package org.moy.spring.test.example.service.impl;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.RoleEntity;
import org.moy.spring.test.example.repository.RoleRepository;
import org.moy.spring.test.example.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>Description: [角色 接口实现]</p>
 * Created on 2018/12/30
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class RoleServiceImpl extends BaseTemplateServiceImpl<RoleRepository, RoleEntity, Long> implements RoleService {
}
