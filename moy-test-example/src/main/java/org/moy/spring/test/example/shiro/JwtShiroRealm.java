package org.moy.spring.test.example.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.moy.spring.test.example.adapter.service.UserAuthInfoAdapterService;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.UserAuthInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Autowired
    private JwtCacheManager jwtCacheManager;
    @Autowired
    private UserAuthInfoAdapterService userAuthInfoAdapterService;

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

        ResultBean<UserAuthInfoDTO> currentUsernameInfo = userAuthInfoAdapterService.getCurrentUserInfo();
        UserAuthInfoDTO data = currentUsernameInfo.getData();

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
