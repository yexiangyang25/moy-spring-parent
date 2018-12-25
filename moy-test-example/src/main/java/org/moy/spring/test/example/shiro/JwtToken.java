package org.moy.spring.test.example.shiro;

import org.apache.shiro.authc.AuthenticationToken;

public class JwtToken implements AuthenticationToken {

    // 密钥
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
