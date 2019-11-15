package org.moy.spring.bus.amqp;

import org.springframework.amqp.core.*;
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

    /**
     * 直接使用队列
     * @return
     */
    @Bean
    public Queue moyQueue() {
        return new Queue(RabbitmqConstants.MOY_QUEUE);
    }
}
