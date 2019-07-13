package org.moy.spring.test.example.shiro;

import org.moy.jwt.shiro.JwtCacheManager;
import org.moy.jwt.shiro.JwtCacheRedisManager;
import org.moy.jwt.shiro.AbstractJwtShiroConfigSpringTemplate;
import org.moy.jwt.shiro.UserAuthInfoManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.StringRedisTemplate;


/**
 * <p>Description: [Shiro 配置]
 * </p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Configuration
@Order(1)
public class JwtShiroConfigSpringTemplate extends AbstractJwtShiroConfigSpringTemplate {

    @Override
    @Bean
    public JwtCacheManager jwtCacheManager(StringRedisTemplate stringRedisTemplate) {
        return new JwtCacheRedisManager(stringRedisTemplate) ;
    }

    @Override
    @Bean
    public UserAuthInfoManager userAuthInfoManager() {
        return new UserAuthInfoCustomManager();
    }
}
