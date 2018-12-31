package org.moy.spring.test.example.shiro;


/**
 * <p>Description: [Jwt 自定义常量]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface JwtConst {

    /**
     * 认证缓存key前缀
     */
    String JWT_CACHE_KEY_PREFIX = "jwt_token_";

    /**
     * 认证识别http头名称
     */
    String TOKEN_HTTP_HEAD = "Authorization";

    /**
     * 无权限跳转用户
     */
    String UN_AUTH_URI = "/unAuth";


    /**
     * 认证加密携带名称信息
     */
    String JWT_CLAIM_USERNAME = "username";

    /**
     * 认证加密携带编码信息
     */
    String JWT_CLAIM_USER_CODE = "userCode";

    /**
     * 过期时间,毫秒单位
     */
    long JWT_EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 认证加密的SECRET
     */
    String JWT_SECRET = "JWT_SECRET";

    /**
     * 默认无权限用户名称
     */
    String JWT_NU_AUTH_USER = "游客";
}
