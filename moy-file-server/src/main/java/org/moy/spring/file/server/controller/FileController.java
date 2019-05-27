package org.moy.spring.file.server.controller;

import org.apache.commons.io.FileUtils;
import org.moy.spring.file.server.component.FileComponent;
import org.moy.spring.file.server.controller.api.FileApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * <p>Description: [文件 rest接口]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
@RestController
public class FileController implements FileApi {

    private final Logger LOG = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private FileComponent fileComponent;

    @Override
    public String uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file") MultipartFile[] files) {
        StringBuilder sb = new StringBuilder();

        for (MultipartFile file : files) {
            String originalFilename = file.getOriginalFilename();
            String fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String serverFilename = UUID.randomUUID().toString() + fileSuffix;
            try {
                File serverFile = new File(fileComponent.getUploadRootPath(), serverFilename);
                FileUtils.copyToFile(file.getInputStream(), serverFile);
                LOG.info("Upload File Absolute Path : {}", serverFile.getAbsolutePath());
                sb.append(fileComponent.getViewRootPath()).append(serverFilename);
            } catch (IOException e) {
                LOG.error("Upload File exception!", e);
            }
        }
        return sb.toString();
    }
}
