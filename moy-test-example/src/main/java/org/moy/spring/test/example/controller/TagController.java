package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.adapter.service.TagAdapterService;
import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.controller.api.TagApi;
import org.moy.spring.test.example.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description: [标签 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class TagController extends BaseController implements TagApi {

    @Autowired
    private TagAdapterService tagAdapterService;

    @Override
    public ResultBean<List<TagDTO>> search(@RequestBody @Validated RequestBean<String> requestBean) {
        return  tagAdapterService.search(requestBean.getRequest());
    }
}
