package org.moy.spring.test.example.adapter.service;

import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.ArticleDTO;
import org.moy.spring.test.example.dto.ArticleQueryDTO;

import java.util.List;

/**
 * <p>Description: [博客文章 适配接口]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
public interface ArticleAdapterService {

    /**
     * 查询文章
     * @param queryDTO
     * @return
     */
    PageResultBean<List<ArticleDTO>> listArticle(ArticleQueryDTO queryDTO);

    /**
     * 创建文章
     *
     * @param dto
     * @return
     */
    ResultBean<Integer> create(ArticleDTO dto);

    /**
     * 根据code查询博客文章
     *
     * @param request
     * @return
     */
    ResultBean<ArticleDTO> getDetailByCode(String request);
}
