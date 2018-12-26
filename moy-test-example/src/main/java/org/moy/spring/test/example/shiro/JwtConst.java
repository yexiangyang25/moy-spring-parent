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

    String JWT_CACHE_KEY_PREFIX = "jwt_token_";

    String TOKEN_HTTP_HEAD = "Authorization";

    String UN_AUTH_URI = "/unAuth";

    String JWT_CLAIM_USERNAME = "username";

    /**
     * 过期时间,毫秒单位
     */
    long JWT_EXPIRE_TIME = 5 * 60 * 1000;

    String JWT_SECRET = "JWT_SECRET";
}
