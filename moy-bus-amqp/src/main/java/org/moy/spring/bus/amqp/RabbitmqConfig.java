package org.moy.spring.bus.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description: [amqp配置]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
