package org.moy.spring.test.example.cache;


import org.moy.spring.test.example.task.BlogConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>Description: [博客缓存实现]</p>
 * Created on 2019/4/7
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class BlogCacheComponent {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 增加缓存
     * @param key
     * @param value
     */
    public void addBlogCache(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(BlogConst.BLOG_CACHE_KEY_PREFIX + key, value, 15, TimeUnit.DAYS);
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public String getBlogCache(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(BlogConst.BLOG_CACHE_KEY_PREFIX + key);
    }

    /**
     * 删除缓存
     * @param key
     */
    public void deleteBlogCache(String key) {
        stringRedisTemplate.delete(BlogConst.BLOG_CACHE_KEY_PREFIX + key);
    }

    /**
     * 统计浏览数
     * @param key
     * @return
     */
    public Long addBlogViewCount(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.increment(BlogConst.BLOG_VIEW_COUNT_PREFIX + key, 1);
    }

    /**
     * 获取浏览数
     * @param key
     * @return
     */
    public Long getBlogViewCount(String key) {
        String value = stringRedisTemplate.opsForValue().get(BlogConst.BLOG_VIEW_COUNT_PREFIX + key);
        return null == value ? 0 : Long.valueOf(value);
    }

}
