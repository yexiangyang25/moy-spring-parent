package org.moy.spring.test.example.controller;

import org.apache.commons.lang3.StringUtils;
import org.moy.jwt.shiro.JwtSecurityUtils;
import org.moy.spring.test.example.adapter.service.ShowLoveWallOrderAdapterService;
import org.moy.spring.common.*;
import org.moy.spring.test.example.dto.ShowLoveWallOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>Description: [欢迎 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestController
public class HelloController {
    @Autowired
    private ShowLoveWallOrderAdapterService showLoveWallOrderAdapterService;

    @GetMapping("/")
    public String hi() {
        return String.format("你好, %s!", JwtSecurityUtils.getCurrentUserName());
    }


    @GetMapping("/info")
    public String info(String key) {
        if (StringUtils.isNotEmpty(key)) {
            ResultBean<ShowLoveWallOrderDTO> detail = showLoveWallOrderAdapterService.getDetailByCode(key);
            ShowLoveWallOrderDTO data = detail.getData();
            return JsonUtil.toJsonString(data);
        }
        return null;
    }
}
