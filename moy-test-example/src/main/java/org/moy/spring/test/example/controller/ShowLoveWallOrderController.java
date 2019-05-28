package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.adapter.service.ShowLoveWallOrderAdapterService;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.RequestBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.common.BaseController;
import org.moy.spring.test.example.controller.api.ShowLoveWallOrderApi;
import org.moy.spring.test.example.dto.OrderQueryDTO;
import org.moy.spring.test.example.dto.ShowLoveWallOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Description: [表白墙 REST接口]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
@RestController
public class ShowLoveWallOrderController extends BaseController implements ShowLoveWallOrderApi {

    @Autowired
    private ShowLoveWallOrderAdapterService showLoveWallOrderAdapterService;

    @Override
    public PageResultBean<List<ShowLoveWallOrderDTO>> list(@RequestBody RequestBean<OrderQueryDTO> requestBean) {
        OrderQueryDTO request = requestBean.getRequest();
        return showLoveWallOrderAdapterService.list(request);
    }

    @Override
    public ResultBean<ShowLoveWallOrderDTO> detail(@RequestBody RequestBean<String> requestBean) {
        String request = requestBean.getRequest();
        return showLoveWallOrderAdapterService.getDetailByCode(request);
    }

    @Override
    public ResultBean<String> create(@RequestBody RequestBean<ShowLoveWallOrderDTO> requestBean) {
        ShowLoveWallOrderDTO request = requestBean.getRequest();
        return showLoveWallOrderAdapterService.create(request);
    }

    @Override
    public ResultBean<String> update(@RequestBody RequestBean<ShowLoveWallOrderDTO> requestBean) {
        return ResultBean.success();
    }
}
