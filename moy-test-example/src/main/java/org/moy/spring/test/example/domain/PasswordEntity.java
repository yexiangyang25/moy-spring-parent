package org.moy.spring.test.example.domain;

import org.moy.spring.test.example.common.BaseEntity;

import java.io.Serializable;

/**
 * <p>Description: [密码 实体]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class PasswordEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -6742767143552683418L;

    private Long id;
    private String code;
    private String userCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "PasswordEntity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", userCode='" + userCode + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", operator='" + operator + '\'' +
                ", operateTime=" + operateTime +
                ", version=" + version +
                '}';
    }
}
