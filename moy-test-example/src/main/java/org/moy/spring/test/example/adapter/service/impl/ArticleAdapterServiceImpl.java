package org.moy.spring.test.example.adapter.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.moy.spring.test.example.adapter.service.ArticleAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.cache.BlogCacheComponent;
import org.moy.spring.test.example.common.*;
import org.moy.spring.test.example.domain.ArticleEntity;
import org.moy.spring.test.example.domain.ArticleTagEntity;
import org.moy.spring.test.example.dto.ArticleDTO;
import org.moy.spring.test.example.dto.ArticleQueryDTO;
import org.moy.spring.test.example.repository.ArticleTagRepository;
import org.moy.spring.test.example.service.ArticleService;
import org.moy.spring.test.example.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [博客文章 适配接口实现]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
@Service
public class ArticleAdapterServiceImpl extends BaseService implements ArticleAdapterService {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTagService articleTagService;
    @Autowired
    private BlogCacheComponent blogCacheComponent;

    @Override
    public PageResultBean<List<ArticleDTO>> listArticle(ArticleQueryDTO queryDTO) {
        PageHelper.startPage(queryDTO.getPage(), queryDTO.getLimit());
        List<ArticleEntity> entityList = articleService.queryByKeywordAndTag(queryDTO.getKeyword(), queryDTO.getTag());
        return PageResultBean.copyPageListToCustomPageResult(entityList, ArticleDTO.class);
    }

    @Override
    public ResultBean<String> create(ArticleDTO dto) {
        ArticleEntity entity = BeanHelper.copyProperties(dto, ArticleEntity.class);
        if (StringUtils.isNotEmpty(entity.getCode())) {
            ArticleEntity queryParam = new ArticleEntity();
            queryParam.setCode(entity.getCode());
            ArticleEntity queryArticle = articleService.getByCondition(queryParam);
            if (NullUtil.objectIsNull(queryArticle)) {
                BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
                articleService.insertAndSaveTags(entity, dto.getTags());
            } else {
                BaseEntityUtil.setUpdateNeedValue(entity);
                articleService.updateAndSaveTags(entity, dto.getTags());
                blogCacheComponent.deleteBlogCache(entity.getCode());
            }
        } else {
            entity.setCode(UuidUtil.newUuid());
            BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
            articleService.insertAndSaveTags(entity, dto.getTags());
        }
        return ResultBean.success(entity.getCode());
    }

    @Override
    public ResultBean<ArticleDTO> getDetailByCode(String request) {
        ArticleDTO dto = null;
        String blogCache = blogCacheComponent.getBlogCache(request);
        if (null != blogCache) {
            dto = JsonUtil.fromJsonString(blogCache, ArticleDTO.class);
        } else {
            ArticleEntity queryParam = new ArticleEntity();
            queryParam.setCode(request);
            ArticleEntity entity = articleService.getByCondition(queryParam);

            dto = BeanHelper.copyProperties(entity, ArticleDTO.class);
            // 添加标签
            List<String> arrayList = getTags(request);
            dto.setTags(arrayList);
            blogCacheComponent.addBlogCache(request, JsonUtil.toJsonString(dto));
        }
        // 浏览数加一
        Long blogViewCount = blogCacheComponent.addBlogViewCount(request);
        dto.setImportance(Math.toIntExact(blogViewCount));
        return ResultBean.success(dto);
    }

    private List<String> getTags(String articleCode) {
        ArticleTagEntity tagEntity = new ArticleTagEntity();
        tagEntity.setArticleCode(articleCode);
        List<ArticleTagEntity> list = articleTagService.query(tagEntity);

        List<String> arrayList = new ArrayList<>(list.size());
        for (ArticleTagEntity each : list) {
            arrayList.add(each.getTagCode());
        }
        return arrayList;
    }
}
