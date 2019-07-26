package org.moy.spring.file.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Description: [文件类型拦截器]</p>
 * Created on 2019/7/25
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Controller
public class FileTypeController {

    public static final String FILE_TYPE_IS_NOT_ALLOW_URI = "/fileTypeIsNotAllow";

    @RequestMapping(FileTypeController.FILE_TYPE_IS_NOT_ALLOW_URI)
    @ResponseBody
    public String fileTypeIsNotAllow() {
        return "不允许上传该文件类型!";
    }
}
