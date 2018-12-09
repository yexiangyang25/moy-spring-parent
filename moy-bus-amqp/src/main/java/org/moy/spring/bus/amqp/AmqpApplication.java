package org.moy.spring.bus.amqp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>Description: [amqp消息 应用入口]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }
}
