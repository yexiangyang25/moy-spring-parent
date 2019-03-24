package org.moy.spring.test.example.service;

import org.moy.spring.test.example.common.BaseTemplateService;
import org.moy.spring.test.example.domain.ArticleTagEntity;
import org.moy.spring.test.example.dto.CountTagDTO;

import java.util.List;

/**
 * <p>Description: [博客标签 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface ArticleTagService extends BaseTemplateService<ArticleTagEntity, Long> {


    /**
     * 总计标签数
     * @return
     */
    List<CountTagDTO> countTag();
}
