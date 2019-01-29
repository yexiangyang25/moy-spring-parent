package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.domain.ArticleEntity;
import org.moy.spring.test.example.repository.ArticleRepository;
import org.moy.spring.test.example.service.ArticleService;
import org.springframework.stereotype.Service;


/**
 * <p>Description: [博客文章 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class ArticleServiceImpl extends BaseTemplateServiceImpl<ArticleRepository, ArticleEntity, Long> implements ArticleService {

}
