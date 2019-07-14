package org.moy.spring.test.example.repository;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.ArticleTagEntity;
import org.moy.spring.test.example.dto.CountTagDTO;

import java.util.List;


/**
 * <p>Description: [博客标签 数据操作]</p>
 * Created on 2019/3/4
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface ArticleTagRepository extends BaseRepository<ArticleTagEntity, Long> {


    /**
     * 总计标签数
     *
     * @return
     */
    List<CountTagDTO> countTag();
}
