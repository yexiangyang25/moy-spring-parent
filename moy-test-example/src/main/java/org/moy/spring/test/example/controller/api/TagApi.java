package org.moy.spring.test.example.controller.api;

import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.LoginDTO;
import org.moy.spring.test.example.dto.TagDTO;
import org.springframework.validation.annotation.Validated;
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
    ResultBean<List<TagDTO>> search(@RequestBody @Validated RequestBean<String> requestBean);
}
