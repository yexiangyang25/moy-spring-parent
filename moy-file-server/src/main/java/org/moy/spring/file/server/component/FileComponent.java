package org.moy.spring.file.server.component;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>Description: [文件 属性]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
@Component
public class FileComponent {

    @Value("${project.upload.root.path}")
    private String uploadRootPath;
    @Value("${project.view.root.path}")
    private String viewRootPath;

    public String getUploadRootPath() {
        return uploadRootPath;
    }

    public String getViewRootPath() {
        return viewRootPath;
    }
}
