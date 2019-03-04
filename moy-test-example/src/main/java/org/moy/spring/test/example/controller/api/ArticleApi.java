package org.moy.spring.test.example.controller.api;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.ArticleDTO;
import org.moy.spring.test.example.dto.ArticleQueryDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>Description: [博客 rest接口]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
public interface ArticleApi {


    /**
     * 查询列表
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/article/list", method = {RequestMethod.POST})
    PageResultBean<List<ArticleDTO>> list(@RequestBody @Validated RequestBean<ArticleQueryDTO> requestBean);


    /**
     * 查询
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/article/detail", method = {RequestMethod.POST})
    ResultBean<ArticleDTO> detail(@RequestBody @Validated RequestBean<String> requestBean);

    /**
     * 创建
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/article/create", method = {RequestMethod.POST})
    ResultBean<String> create(@RequestBody @Validated RequestBean<ArticleDTO> requestBean);

    /**
     * 更新
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/article/update", method = {RequestMethod.POST})
    ResultBean<String> update(@RequestBody @Validated RequestBean<ArticleDTO> requestBean);
}
