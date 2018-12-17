package org.moy.spring.test.example.dto;

import org.moy.spring.test.example.common.BaseEntity;

import java.io.Serializable;

/**
 * <p>Description: [用户 实体]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class UserDTO extends BaseEntity implements Serializable {

    private String code;
    private String name;
    private String telephone;
    private Integer status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", operator='" + operator + '\'' +
                ", operateTime=" + operateTime +
                ", version=" + version +
                '}';
    }
}
