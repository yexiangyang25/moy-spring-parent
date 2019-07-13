package org.moy.spring.test.example.domain;


import org.moy.spring.common.*;


import java.io.Serializable;

/**
 * <p>Description: [用户角色 关系实体]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class UserRoleEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3600842107004537809L;
    private Long id;
    private String userCode;
    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
