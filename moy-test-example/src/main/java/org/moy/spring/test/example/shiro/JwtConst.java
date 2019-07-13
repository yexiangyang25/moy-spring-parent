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
     * 默认无权限用户名称
     */
    String JWT_NU_AUTH_USER = "游客";
}
