package org.moy.spring.test.example.repository;

import org.apache.ibatis.annotations.Param;
import org.moy.spring.test.example.common.BaseRepository;
import org.moy.spring.test.example.domain.ArticleEntity;

import java.util.List;


/**
 * <p>Description: [博客文章 数据操作]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface ArticleRepository extends BaseRepository<ArticleEntity, Long> {

    /**
     * 根据关键字和标签查询
     *
     * @param keyword
     * @param tag
     * @return
     */
    List<ArticleEntity> queryByKeywordAndTag(@Param("keyword") String keyword, @Param("tag") String tag);


    /**
     * 更新浏览数
     * @param entity
     * @param oldViewCount
     * @return
     */
    Integer updateViewCount(@Param("entity") ArticleEntity entity , @Param("oldViewCount")Integer oldViewCount);
}
