package org.moy.spring.file.server.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.moy.spring.file.server.controller.FileTypeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>Description: [文件类型拦截器]</p>
 * Created on 2019/7/25
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class FileTypeInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(FileTypeInterceptor.class);

    private String allowFileSuffix;

    public FileTypeInterceptor(String allowFileSuffix) {
        this.allowFileSuffix = allowFileSuffix;
    }

    public void setAllowFileSuffix(String allowFileSuffix) {
        this.allowFileSuffix = allowFileSuffix;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = true;
        // 判断是否为文件上传请求
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files = multipartRequest.getFileMap();
            if (null != files && !files.isEmpty()) {
                //对多部件请求资源进行遍历
                for (MultipartFile multipartFile : files.values()) {
                    String filename = multipartFile.getOriginalFilename();
                    //判断是否为限制文件类型
                    if (!checkFileIsAllow(filename)) {
                        response.sendRedirect(FileTypeController.FILE_TYPE_IS_NOT_ALLOW_URI);
                        flag = false;
                    }
                }
            }

        }
        return flag;
    }

    /**
     * 判断是否为允许的上传文件类型,true表示允许
     */
    private boolean checkFileIsAllow(String fileName) {
        //设置允许上传文件类型
        if (null == allowFileSuffix || allowFileSuffix.isEmpty()
                || null == fileName || !fileName.contains(".")) {
            LOG.error("获取允许上传文件类型配置或上传文件类型失败! 上传文件名:[{}]", fileName);
            return false;
        }

        String[] allowFileSuffixArray = allowFileSuffix.split(",");
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        for (String each : allowFileSuffixArray) {
            if (StringUtils.equalsIgnoreCase(each, suffix)) {
                return true;
            }
        }
        LOG.error("该上传文件类型不允许! 上传文件名:[{}]", fileName);
        return false;
    }
}
