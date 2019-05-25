package org.moy.spring.test.example.controller;

import org.moy.spring.test.example.common.JsonUtil;
import org.moy.spring.test.example.shiro.JwtSecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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

    @GetMapping("/")
    public String hi() {
        return String.format("你好, %s!", JwtSecurityUtils.getCurrentUserName());
    }


    @GetMapping("/info")
    public String info(String key) {
        HashMap<String, Object> map = new HashMap<>(10);
        // 7/12/2017
        map.put("date", "6/12/2017");
        map.put("mr", key);
        map.put("mrs", key);
        map.put("title", key);
        map.put("signature", key);
        return JsonUtil.toJsonString(map);
    }
}
