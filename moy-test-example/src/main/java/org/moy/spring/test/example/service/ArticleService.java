package org.moy.spring.test.example.service;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.ArticleEntity;

import java.util.List;

/**
 * <p>Description: [博客文章 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface ArticleService extends BaseTemplateService<ArticleEntity, Long> {


    /**
     * 根据关键字和标签查询
     * @param keyword
     * @param tag
     * @return
     */
    List<ArticleEntity> queryByKeywordAndTag(String keyword, String tag);


    /**
     * 保存文章和标签
     * @param entity
     * @param tags
     * @return
     */
    Integer insertAndSaveTags(ArticleEntity entity , List<String> tags);


    /**
     * 更新文章和标签
     * @param entity
     * @param tags
     * @return
     */
    Integer updateAndSaveTags(ArticleEntity entity , List<String> tags);


    /**
     * 更新浏览数
     *
     * @param code
     * @param viewCount
     * @return
     */
    Integer updateViewCount(String code, Integer viewCount);
}
