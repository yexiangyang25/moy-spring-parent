package org.moy.spring.test.example.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>Description: [Jwt 自定义缓存实现]</p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class JwtCacheRedisManager implements JwtCacheManager {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String saveToken(String uniqueCredential, Map<String, String> extraInfoMap) {
        return saveToken(uniqueCredential, JwtHelper.JWT_EXPIRE_TIME, extraInfoMap);
    }

    @Override
    public String saveToken(String uniqueCredential, long expireTime, Map<String, String> extraInfoMap) {
        String token = JwtHelper.createToken(uniqueCredential, expireTime, extraInfoMap);
        String tokenRedisKey = getTokenRedisKey(token);
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set(tokenRedisKey, token, JwtHelper.JWT_EXPIRE_TIME, TimeUnit.MILLISECONDS);
        return token;
    }

    @Override
    public Boolean deleteToken(String token) {
        if (null == token) {
            return false;
        }
        String tokenRedisKey = getTokenRedisKey(token);
        return stringRedisTemplate.delete(tokenRedisKey);
    }

    private String getTokenRedisKey(String token) {
        return JwtConst.JWT_CACHE_KEY_PREFIX + JwtHelper.getUniqueCredentialInfo(token);
    }

    @Override
    public String getToken(String token) {
        String tokenRedisKey = getTokenRedisKey(token);
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        return opsForValue.get(tokenRedisKey);
    }

    @Override
    public void verifyToken(String token) {
        String redisToken = getToken(token);
        if (!StringUtils.equals(token, redisToken)) {
            throw new AuthenticationException("token invalid , not found from redis!");
        }
    }
}
