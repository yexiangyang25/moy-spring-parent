package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.adapter.service.ArticleAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.controller.api.ArticleApi;
import org.moy.spring.test.example.dto.ArticleDTO;
import org.moy.spring.test.example.dto.ArticleQueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description: [博客文章 REST接口]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
@RestController
public class ArticleController extends BaseController implements ArticleApi {

    @Autowired
    private ArticleAdapterService articleAdapterService;

    @Override
    public PageResultBean<List<ArticleDTO>> list(@RequestBody RequestBean<ArticleQueryDTO> requestBean) {
        ArticleQueryDTO request = requestBean.getRequest();
        return articleAdapterService.listArticle(request);
    }

    @Override
    public ResultBean<ArticleDTO> detail(@RequestBody RequestBean<String> requestBean) {
        String request = requestBean.getRequest();
        return articleAdapterService.getDetailByCode(request);
    }

    @Override
    public ResultBean<String> create(@RequestBody RequestBean<ArticleDTO> requestBean) {
        ArticleDTO request = requestBean.getRequest();
        return articleAdapterService.create(request);
    }

    @Override
    public ResultBean<String> update(@RequestBody RequestBean<ArticleDTO> requestBean) {
        return ResultBean.success();
    }
}
