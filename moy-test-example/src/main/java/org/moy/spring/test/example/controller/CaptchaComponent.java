package org.moy.spring.test.example.controller;

import org.apache.commons.lang3.StringUtils;
import org.moy.spring.common.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description: [验证码]</p>
 * Created on 2019/7/25
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class CaptchaComponent {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final String CAPTCHA_PREFIX = "captcha_";

    /**
     * 保存
     *
     * @param uid
     * @param capText
     */
    void saveCaptcha(String uid, String capText) {
        stringRedisTemplate.opsForValue().set(CAPTCHA_PREFIX + uid, capText, 60 * 2, TimeUnit.SECONDS);
    }

    /**
     * 校验
     *
     * @param uid
     * @param capText
     * @return
     */
    void checkCaptchaIsError(String uid, String capText) {
        String key = CAPTCHA_PREFIX + uid;
        String value = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isNotEmpty(key)) {
            stringRedisTemplate.delete(key);
        }
        if (!StringUtils.equalsIgnoreCase(capText, value)) {
            ExceptionUtil.newBusinessException("captcha is Error!");
        }
    }
}
