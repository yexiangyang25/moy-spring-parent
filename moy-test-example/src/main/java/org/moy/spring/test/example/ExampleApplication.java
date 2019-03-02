package org.moy.spring.test.example;

import org.moy.spring.config.CorsFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;


/**
 * <p>Description: [程序入口]</p>
 * Created on 2018/9/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@SpringBootApplication
@ImportResource("classpath:/spring/spring-import.xml")
@MapperScan("org.moy.spring.test.example.repository")
@EnableAspectJAutoProxy
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }


    @Bean
    public CorsFilter corsFilter(){
        return new CorsFilter();
    }
}
