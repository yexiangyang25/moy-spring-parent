package org.moy.spring.file.server.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description: [文件 rest接口]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
public interface FileApi {

    /**
     * 上传文件
     * @param request
     * @param response
     * @param files
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    String uploadFile(HttpServletRequest request,
                      HttpServletResponse response,
                      @RequestParam(value = "file") MultipartFile[] files);

}
