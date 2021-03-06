package org.moy.spring.test.example.dto;

import org.moy.spring.test.example.aop.MessageKeyConstants;
import org.moy.spring.common.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>Description: [登录 实体]</p>
 * Created on 2018/1/11
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = -4405902263828345467L;
    @NotBlank(message = MessageKeyConstants.MESSAGE_LOGIN_USERNAME)
    private String username;
    @NotBlank(message = MessageKeyConstants.MESSAGE_LOGIN_PASSWORD)
    private String password;
    private String uid;
    private String imageCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
