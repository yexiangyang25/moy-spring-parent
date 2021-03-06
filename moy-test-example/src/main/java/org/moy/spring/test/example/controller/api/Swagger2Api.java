package org.moy.spring.test.example.controller.api;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * <p>Description: [Swagger2 测试]</p>
 * Created on 2018/12/13
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface Swagger2Api {

    /**
     * 打招呼
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "打招呼", notes = "打招呼")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String")})
    @GetMapping("/hi")
    String sayHi(String name);
}
