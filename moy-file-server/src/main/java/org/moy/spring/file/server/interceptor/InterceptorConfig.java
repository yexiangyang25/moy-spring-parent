package org.moy.spring.file.server.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Description: [文件类型拦截器]</p>
 * Created on 2019/7/25
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private FileTypeInterceptor fileTypeInterceptor;


    @Bean
    public FileTypeInterceptor fileTypeInterceptor() {
        return new FileTypeInterceptor("jpg,gif,png,ico,bmp,jpeg,xls,xlsx,pdf");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(fileTypeInterceptor).addPathPatterns("/**");
    }
}
