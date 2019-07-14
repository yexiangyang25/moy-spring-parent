package org.moy.spring.test.example.controller.api;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.moy.spring.common.*;
import org.moy.spring.test.example.dto.ArticleDTO;
import org.moy.spring.test.example.dto.ArticleQueryDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>Description: [博客 rest接口]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public interface ArticleApi {


    /**
     * 查询列表
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/article/list", method = {RequestMethod.POST})
    PageResultBean<List<ArticleDTO>> list(@RequestBody RequestBean<ArticleQueryDTO> requestBean);


    /**
     * 查询
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/article/detail", method = {RequestMethod.POST})
    ResultBean<ArticleDTO> detail(@RequestBody RequestBean<String> requestBean);

    /**
     * 创建
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/article/create", method = {RequestMethod.POST})
    ResultBean<String> create(@RequestBody RequestBean<ArticleDTO> requestBean);

    /**
     * 更新
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/article/update", method = {RequestMethod.POST})
    ResultBean<String> update(@RequestBody RequestBean<ArticleDTO> requestBean);
}
