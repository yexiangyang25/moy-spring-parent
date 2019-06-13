package org.moy.spring.test.example.adapter.service.impl;

import com.github.pagehelper.PageHelper;
import org.moy.spring.test.example.adapter.service.ShowLoveWallOrderAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.*;

import org.moy.spring.test.example.domain.ShowLoveWallOrderEntity;
import org.moy.spring.test.example.dto.OrderQueryDTO;
import org.moy.spring.test.example.dto.ShowLoveWallOrderDTO;
import org.moy.spring.test.example.service.ShowLoveWallOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * <p>Description: [表白墙 适配接口实现]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
@Service
public class ShowLoveWallOrderAdapterServiceImpl extends BaseService implements ShowLoveWallOrderAdapterService {
    @Autowired
    private ShowLoveWallOrderService showLoveWallOrderService;

    @Override
    public PageResultBean<List<ShowLoveWallOrderDTO>> list(OrderQueryDTO request) {
        PageHelper.startPage(request.getPage(), request.getLimit());
        List<ShowLoveWallOrderEntity> entityList = showLoveWallOrderService.findAll();
        return PageResultBean.copyPageListToCustomPageResult(entityList, ShowLoveWallOrderDTO.class);
    }

    @Override
    public ResultBean<ShowLoveWallOrderDTO> getDetailByCode(String request) {
        ShowLoveWallOrderEntity dto = new ShowLoveWallOrderEntity();
        dto.setCode(request);
        ShowLoveWallOrderEntity entity = showLoveWallOrderService.getByCondition(dto);
        return ResultBean.success(BeanHelper.copyProperties(entity, ShowLoveWallOrderDTO.class));
    }

    @Override
    public ResultBean<String> create(ShowLoveWallOrderDTO request) {
        ShowLoveWallOrderEntity entity = BeanHelper.copyProperties(request, ShowLoveWallOrderEntity.class);
        if (NullUtil.charSequenceIsEmpty(entity.getCode())) {
            String uuid = UuidUtil.newUuid();
            entity.setCode(uuid);
            BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
            showLoveWallOrderService.insert(entity);
        } else {
            BaseEntityUtil.setUpdateNeedValue(entity);
            showLoveWallOrderService.update(entity);
        }
        return ResultBean.success(entity.getCode());
    }
}
