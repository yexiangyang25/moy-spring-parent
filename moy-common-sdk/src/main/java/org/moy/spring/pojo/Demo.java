package org.moy.spring.pojo;

import java.io.Serializable;
/**
 * <p>Description: [测试 参数对象]</p>
 * Created on 2018/12/02
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class Demo implements Serializable {
    private static final long serialVersionUID = -3930058990427525203L;
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "Demo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
