package org.moy.spring.test.example.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * <p>Description: [自定义 Shiro Realm 实现权限认证]
 * </p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JwtShiroRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }


    /**
     * 此方法调用hasRole,hasPermission的时候才会进行回调
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JwtUtil.getUsername(principalCollection.toString());

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addRole("admin");

        authorizationInfo.addStringPermission("root");

        return authorizationInfo;
    }


    /**
     * 认证信息(身份验证)
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
