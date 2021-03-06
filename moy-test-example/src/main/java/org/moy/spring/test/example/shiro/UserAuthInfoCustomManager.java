package org.moy.spring.test.example.shiro;

import org.moy.jwt.shiro.JwtConst;
import org.moy.jwt.shiro.JwtSecurityUtils;
import org.moy.jwt.shiro.UserAuthInfoManager;
import org.moy.spring.test.example.domain.RolePermissionEntity;
import org.moy.spring.test.example.domain.UserRoleEntity;
import org.moy.spring.test.example.service.RolePermissionService;
import org.moy.spring.test.example.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [用户权限信息 适配接口]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class UserAuthInfoCustomManager implements UserAuthInfoManager {

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public UserAuthInfoDTO getCurrentUserInfo() {
        UserAuthInfoDTO result = new UserAuthInfoDTO();
        String currentUserName = JwtSecurityUtils.getCurrentUserName();
        String currentUserCode = JwtSecurityUtils.getCurrentUserCode();
        result.setName(currentUserName);
        result.setCode(currentUserCode);
        if (!JwtConst.JWT_NU_AUTH_USER.equals(currentUserName)) {
            List<UserRoleEntity> userRoleEntityList = userRoleService.queryByUserCode(currentUserCode);
            List<String> roles = new ArrayList<>(userRoleEntityList.size());
            List<String> permissions = new ArrayList<>();
            for (UserRoleEntity each : userRoleEntityList) {
                String roleCode = each.getRoleCode();
                roles.add(roleCode);
                List<RolePermissionEntity> rolePermissionEntityList = rolePermissionService.queryByRoleCode(roleCode);
                for (RolePermissionEntity eachRolePermissionEntity : rolePermissionEntityList) {
                    String permissionCode = eachRolePermissionEntity.getPermissionCode();
                    permissions.add(permissionCode);
                }
            }
            result.setRoles(roles);
            result.setPermissions(permissions);
        }
        return result;
    }
}
