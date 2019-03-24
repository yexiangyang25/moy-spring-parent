package org.moy.spring.test.example.service.impl;

import org.moy.spring.test.example.common.BaseTemplateServiceImpl;
import org.moy.spring.test.example.domain.ArticleEntity;
import org.moy.spring.test.example.domain.ArticleTagEntity;
import org.moy.spring.test.example.dto.CountTagDTO;
import org.moy.spring.test.example.repository.ArticleRepository;
import org.moy.spring.test.example.repository.ArticleTagRepository;
import org.moy.spring.test.example.service.ArticleService;
import org.moy.spring.test.example.service.ArticleTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>Description: [博客标签 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class ArticleTagServiceImpl extends BaseTemplateServiceImpl<ArticleTagRepository, ArticleTagEntity, Long> implements ArticleTagService {
    @Resource
    private ArticleTagRepository articleTagRepository;

    @Override
    public List<CountTagDTO> countTag() {
        return articleTagRepository.countTag();
    }
}
