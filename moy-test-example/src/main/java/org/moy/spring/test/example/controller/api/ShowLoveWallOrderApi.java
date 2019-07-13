package org.moy.spring.test.example.controller.api;

import org.moy.spring.common.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.moy.spring.test.example.dto.OrderQueryDTO;
import org.moy.spring.test.example.dto.ShowLoveWallOrderDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <p>Description: [表白墙 rest接口]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public interface ShowLoveWallOrderApi {


    /**
     * 查询列表
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/order/love/list", method = {RequestMethod.POST})
    PageResultBean<List<ShowLoveWallOrderDTO>> list(@RequestBody RequestBean<OrderQueryDTO> requestBean);


    /**
     * 查询
     *
     * @param requestBean
     * @return
     */
    @RequestMapping(value = "/order/love/detail", method = {RequestMethod.POST})
    ResultBean<ShowLoveWallOrderDTO> detail(@RequestBody RequestBean<String> requestBean);

    /**
     * 创建
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/order/love/create", method = {RequestMethod.POST})
    ResultBean<String> create(@RequestBody RequestBean<ShowLoveWallOrderDTO> requestBean);

    /**
     * 更新
     *
     * @param requestBean
     * @return
     */
    @RequiresAuthentication
    @RequestMapping(value = "/order/love/update", method = {RequestMethod.POST})
    ResultBean<String> update(@RequestBody RequestBean<ShowLoveWallOrderDTO> requestBean);
}
