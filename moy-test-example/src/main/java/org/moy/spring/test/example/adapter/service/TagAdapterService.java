package org.moy.spring.test.example.adapter.service;

import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.TagDTO;

import java.util.List;

/**
 * <p>Description: [标签 适配接口]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface TagAdapterService {


    /**
     * 查询
     * @param query
     * @return
     */
    ResultBean<List<TagDTO>> search(String query);
}