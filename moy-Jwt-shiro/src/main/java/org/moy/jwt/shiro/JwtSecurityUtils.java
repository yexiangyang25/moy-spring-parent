package org.moy.jwt.shiro;

import org.apache.shiro.SecurityUtils;


/**
 * <p>Description: [Jwt 获取当前用户信息工具]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JwtSecurityUtils {

    public static final String USERNAME = "username";
    /**
     * 获取当前用户名称
     *
     * @return
     */
    public static String getCurrentUserName() {
        String username = JwtConst.JWT_NU_AUTH_USER;
        Object principal = getCurrentPrincipal();
        if (null != principal) {
            username = JwtHelper.getClaimInfoByKey(principal.toString() ,USERNAME);
        }
        return username;
    }

    /**
     * 获取token
     *
     * @return
     */
    public static String getCurrentPrincipal() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        if (null == principal) {
            return null;
        }
        return principal.toString();
    }

    /**
     * 获取当前用户编码
     *
     * @return
     */
    public static String getCurrentUserCode() {
        String username = JwtConst.JWT_NU_AUTH_USER;
        Object principal = getCurrentPrincipal();
        if (null != principal) {
            username = JwtHelper.getUniqueCredentialInfo(principal.toString());
        }
        return username;
    }
}
