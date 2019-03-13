package org.moy.spring.test.example.adapter.service.impl;

import org.moy.spring.test.example.adapter.service.TagAdapterService;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseService;
import org.moy.spring.test.example.common.BeanHelper;
import org.moy.spring.test.example.domain.TagEntity;
import org.moy.spring.test.example.dto.TagDTO;
import org.moy.spring.test.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>Description: [标签 适配接口实现]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class TagAdapterServiceImpl extends BaseService implements TagAdapterService {

    @Autowired
    private TagService tagService;

    @Override
    public ResultBean<List<TagDTO>> search(String query) {
        TagEntity entity = new TagEntity();
        entity.setCode(query);
        List<TagEntity> entityList = tagService.query(entity);
        List<TagDTO> dtoList = BeanHelper.copyList(entityList, TagDTO.class);
        return ResultBean.success(dtoList);
    }
}
