package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.domain.ArticleEntity;
import org.moy.spring.test.example.dto.ArticleQueryDTO;
import org.moy.spring.test.example.repository.ArticleRepository;
import org.moy.spring.test.example.repository.TagRepository;
import org.moy.spring.test.example.service.ArticleService;
import org.moy.spring.test.example.service.ArticleTagService;
import org.moy.spring.test.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


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

    @Resource
    private ArticleRepository articleRepository;
    @Resource
    private ArticleTagService articleTagService;

    @Override
    public List<ArticleEntity> queryByKeywordAndTag(String keyword, String tag) {
        return articleRepository.queryByKeywordAndTag(keyword, tag);
    }

    @Override
    public Integer insertAndSaveTags(ArticleEntity entity, List<String> tags) {
        articleTagService.saveTags(entity.getCode(), tags);
        return insert(entity);
    }

    @Override
    public Integer updateAndSaveTags(ArticleEntity entity, List<String> tags) {
        articleTagService.saveTags(entity.getCode(), tags);
        return update(entity);
    }
}
