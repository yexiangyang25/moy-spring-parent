package org.moy.jwt.shiro;

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

    private JwtCacheManager jwtCacheManager;
    private UserAuthInfoManager userAuthInfoManager;

    public  JwtShiroRealm(JwtCacheManager jwtCacheManager , UserAuthInfoManager userAuthInfoManager){
        this.jwtCacheManager = jwtCacheManager;
        this.userAuthInfoManager = userAuthInfoManager;
    }

    public void setJwtCacheManager(JwtCacheManager jwtCacheManager) {
        this.jwtCacheManager = jwtCacheManager;
    }

    public void setUserAuthInfoAdapterService(UserAuthInfoManager userAuthInfoManager) {
        this.userAuthInfoManager = userAuthInfoManager;
    }

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

        UserAuthInfo data = userAuthInfoManager.getCurrentUserInfo();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addRoles(data.getRoles());

        authorizationInfo.addStringPermissions(data.getPermissions());

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

        if (JwtHelper.verifyIsNotOk(token)) {
            throw new AuthenticationException("token invalid");
        }
        jwtCacheManager.verifyToken(token);
        return new SimpleAuthenticationInfo(token, token, "jwtRealm");
    }
}
