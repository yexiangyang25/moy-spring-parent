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
public class RabbitmqDirectExchangeConfig {

    /**
     * 直接点对点模式
     *
     * @return
     */
    @Bean
    public DirectExchange moyDirectExchange() {
        return new DirectExchange(RabbitmqConstants.MOY_DIRECT_EXCHANGE);
    }

    @Bean
    public Queue moyDirectExchangeQueue() {
        return new Queue(RabbitmqConstants.MOY_DIRECT_EXCHANGE_QUEUE);
    }


    @Bean
    public Binding bindingMoyDirectExchange() {
        return BindingBuilder.bind(moyDirectExchangeQueue())
                .to(moyDirectExchange()).with(RabbitmqConstants.MOY_DIRECT_EXCHANGE_ROUTING_KEY);
    }
}
