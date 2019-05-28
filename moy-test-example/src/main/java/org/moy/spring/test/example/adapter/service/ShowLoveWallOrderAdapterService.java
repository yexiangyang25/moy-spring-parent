package org.moy.spring.test.example.adapter.service;


import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.beans.ResultBean;
import org.moy.spring.test.example.dto.OrderQueryDTO;
import org.moy.spring.test.example.dto.ShowLoveWallOrderDTO;

import java.util.List;

/**
 * <p>Description: [表白墙 适配接口]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public interface ShowLoveWallOrderAdapterService {

    /**
     * 查询
     * @param request
     * @return
     */
    PageResultBean<List<ShowLoveWallOrderDTO>> list(OrderQueryDTO request);

    /**
     * 按编码查询
     * @param request
     * @return
     */
    ResultBean<ShowLoveWallOrderDTO> getDetailByCode(String request);

    /**
     * 创建
     * @param request
     * @return
     */
    ResultBean<String> create(ShowLoveWallOrderDTO request);
}
