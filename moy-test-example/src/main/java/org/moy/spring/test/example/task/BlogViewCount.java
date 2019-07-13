package org.moy.spring.test.example.task;


import org.apache.commons.lang3.math.NumberUtils;
import org.moy.spring.common.NullUtil;
import org.moy.spring.test.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <p>Description: [统计浏览数]</p>
 * Created on 2019/4/7
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class BlogViewCount {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ArticleService articleService;


    @Scheduled(cron="0 0 0 1,15 * ?")
    public void task() {
        Set<String> keys = stringRedisTemplate.keys(BlogConst.BLOG_VIEW_COUNT_PREFIX + "*");
        if (NullUtil.collectionIsNotEmpty(keys)) {
            for (String key : keys) {
                String code = key.substring(BlogConst.BLOG_VIEW_COUNT_PREFIX.length());
                String value = stringRedisTemplate.opsForValue().get(key);
                if (NumberUtils.isDigits(value)) {
                    articleService.updateViewCount(code, Integer.valueOf(value));
                }
            }
        }
    }
}
