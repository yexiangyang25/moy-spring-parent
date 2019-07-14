package org.moy.jwt.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * <p>Description: [自定义 Shiro Token ]
 * </p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JwtToken implements AuthenticationToken {

    /**
     * 密钥
     */
    private String token;

    private JwtToken(String token) {
        this.token = token;
    }

    public static JwtToken newToken(String token) {
        return new JwtToken(token);
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
