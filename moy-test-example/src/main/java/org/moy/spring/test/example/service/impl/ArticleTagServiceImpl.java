package org.moy.spring.test.example.service.impl;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.ArticleTagEntity;
import org.moy.spring.test.example.dto.CountTagDTO;
import org.moy.spring.test.example.repository.ArticleTagRepository;
import org.moy.spring.test.example.service.ArticleTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public Integer saveTags(String articleCode, List<String> tags) {
        ArticleTagEntity articleTagEntity = new ArticleTagEntity();
        articleTagEntity.setArticleCode(articleCode);
        articleTagRepository.deleteByCondition(articleTagEntity);

        if (NullUtil.collectionIsNotEmpty(tags)) {
            List<ArticleTagEntity> arrayList = new ArrayList<>(tags.size());
            for (String tag : tags) {
                ArticleTagEntity entity = new ArticleTagEntity();
                entity.setArticleCode(articleCode);
                entity.setTagCode(tag);
                arrayList.add(entity);
            }
            articleTagRepository.addAll(arrayList);
        }
        return 0;
    }
}
