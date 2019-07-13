package org.moy.spring.test.example.shiro;


import java.util.Map;

/**
 * <p>Description: [Jwt 自定义缓存]</p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface JwtCacheManager {


    /**
     * 保存JWT缓存
     *
     * @param uniqueCredential
     * @param extraInfoMap
     * @return
     */
    String saveToken(String uniqueCredential, Map<String, String> extraInfoMap);

    /**
     * 保存JWT缓存
     *
     * @param uniqueCredential
     * @param expireTime
     * @param extraInfoMap
     * @return
     */
    String saveToken(String uniqueCredential, long expireTime, Map<String, String> extraInfoMap);

    /**
     * 删除JWT缓存
     *
     * @param token
     * @return
     */
    Boolean deleteToken(String token);

    /**
     * 获取JWT缓存
     *
     * @param token
     * @return
     */
    String getToken(String token);

    /**
     * 校验JWT缓存
     *
     * @param token
     */
    void verifyToken(String token);
}
