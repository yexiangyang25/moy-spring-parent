package org.moy.spring.test.example.controller.api;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.CountTagDTO;
import org.moy.spring.test.example.dto.TagDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * <p>Description: [标签 REST API]</p>
 * Created on 2018/12/13
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface TagApi {

    /**
     * 标签查询
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/tag/search", method = {RequestMethod.GET, RequestMethod.POST})
    ResultBean<List<TagDTO>> search(@RequestBody RequestBean<String> requestBean);

    /**
     * 新增
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/tag/add", method = {RequestMethod.POST})
    ResultBean<Integer> add(@RequestBody RequestBean<String> requestBean);


    /**
     * 删除
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/tag/delete", method = {RequestMethod.POST})
    ResultBean<Integer> delete(@RequestBody RequestBean<String> requestBean);

    /**
     * 总计标签数
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/tag/countTag", method = {RequestMethod.POST})
    ResultBean<List<TagDTO>> countTag(@RequestBody RequestBean<String> requestBean);
}
