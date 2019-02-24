package org.moy.spring.file.server.component;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>Description: [文件 rest接口]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
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
