package org.moy.spring.test.example.adapter.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.moy.spring.test.example.adapter.service.ArticleAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseEntityUtil;
import org.moy.spring.test.example.common.BaseService;
import org.moy.spring.test.example.common.BeanHelper;
import org.moy.spring.test.example.common.UuidUtil;
import org.moy.spring.test.example.domain.ArticleEntity;
import org.moy.spring.test.example.dto.ArticleDTO;
import org.moy.spring.test.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: [博客文章 适配接口实现]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
@Service
public class ArticleAdapterServiceImpl extends BaseService implements ArticleAdapterService {
    @Autowired
    private ArticleService articleService;

    @Override
    public PageResultBean<List<ArticleDTO>> listArticle() {
        PageHelper.startPage(1, 10);
        List<ArticleEntity> entityList = articleService.findAll();
        return PageResultBean.copyPageListToCustomPageResult(entityList, ArticleDTO.class);
    }

    @Override
    public ResultBean<Integer> create(ArticleDTO dto) {
        ArticleEntity entity = BeanHelper.copyProperties(dto, ArticleEntity.class);
        if (StringUtils.isNotEmpty(entity.getCode())) {
            BaseEntityUtil.setUpdateNeedValue(entity);
            Integer update = articleService.update(entity);
            return ResultBean.success(update);
        } else {
            entity.setCode(UuidUtil.newUuid());
            BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
            Integer insert = articleService.insert(entity);
            return ResultBean.success(insert);
        }
    }

    @Override
    public ResultBean<ArticleDTO> getDetailByCode(String request) {
        ArticleEntity queryParam = new ArticleEntity();
        queryParam.setCode(request);
        ArticleEntity entity = articleService.get(queryParam);
        ArticleDTO dto = BeanHelper.copyProperties(entity, ArticleDTO.class);
        return ResultBean.success(dto);
    }
}
