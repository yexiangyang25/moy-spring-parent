package org.moy.spring.test.example.adapter.service.impl;

import org.moy.spring.test.example.adapter.service.TagAdapterService;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.*;
import org.moy.spring.test.example.domain.TagEntity;
import org.moy.spring.test.example.dto.CountTagDTO;
import org.moy.spring.test.example.dto.TagDTO;
import org.moy.spring.test.example.service.ArticleTagService;
import org.moy.spring.test.example.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private ArticleTagService articleTagService;

    @Override
    public ResultBean<List<TagDTO>> search(String query) {
        TagEntity entity = new TagEntity();
        entity.setCode(query);
        List<TagEntity> entityList = tagService.query(entity);
        List<TagDTO> dtoList = BeanHelper.copyList(entityList, TagDTO.class);
        return ResultBean.success(dtoList);
    }

    @Override
    public ResultBean<Integer> add(String name) {
        TagEntity entity = new TagEntity();
        entity.setCode(name);
        entity.setName(name);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
        return ResultBean.success(tagService.insert(entity));
    }

    @Override
    public ResultBean<Integer> delete(String name) {
        TagEntity entity = new TagEntity();
        entity.setName(name);
        return ResultBean.success(tagService.deleteByCondition(entity));
    }

    @Override
    public ResultBean<List<TagDTO>> countTag() {
        List<CountTagDTO> dtoList = articleTagService.countTag();
        Long count = articleTagService.count();
        return ResultBean.success(buildListDTO(dtoList, count));
    }

    private List<TagDTO> buildListDTO(List<CountTagDTO> dtoList, Long count) {
        if (NullUtil.collectionIsNotEmpty(dtoList)) {
            List<TagDTO> list = new ArrayList<>(dtoList.size());
            for (CountTagDTO each : dtoList) {
                TagDTO dto = new TagDTO();
                dto.setCode(each.getCode());
                double percentage = BigDecimalUtil.multiply(100, BigDecimalUtil.divide(each.getCount(), count));
                dto.setPercentage((int) percentage);
                list.add(dto);
            }
            return list;
        }
        return null;
    }
}
