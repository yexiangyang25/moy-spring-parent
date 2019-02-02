package org.moy.spring.test.example.dto;


import org.moy.spring.test.example.common.JsonUtil;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [用户权限信息 实体]</p>
 * Created on 2018/12/31
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class UserAuthInfoDTO extends UserDTO implements Serializable {

    private static final long serialVersionUID = -8128990031161992815L;

    private List<String> roles;
    private List<String> permissions;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
