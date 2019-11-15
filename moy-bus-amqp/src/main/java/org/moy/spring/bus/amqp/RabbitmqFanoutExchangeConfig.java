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
public class RabbitmqFanoutExchangeConfig {

    /**
     * 使用广播模式
     *
     * @return
     */
    @Bean
    public FanoutExchange moyFanoutExchange() {
        return new FanoutExchange(RabbitmqConstants.MOY_FANOUT_EXCHANGE);
    }

    @Bean
    public Queue moyFanoutExchangeQueueA() {
        return new Queue(RabbitmqConstants.MOY_FANOUT_EXCHANGE_QUEUE_A);
    }

    @Bean
    public Binding bindingMoyFanoutExchangeA() {
        return BindingBuilder.bind(moyFanoutExchangeQueueA()).to(moyFanoutExchange());
    }

    @Bean
    public Queue moyFanoutExchangeQueueB() {
        return new Queue(RabbitmqConstants.MOY_FANOUT_EXCHANGE_QUEUE_B);
    }

    @Bean
    public Binding bindingMoyFanoutExchangeB() {
        return BindingBuilder.bind(moyFanoutExchangeQueueB()).to(moyFanoutExchange());
    }

    @Bean
    public Queue moyFanoutExchangeQueueC() {
        return new Queue(RabbitmqConstants.MOY_FANOUT_EXCHANGE_QUEUE_C);
    }

    @Bean
    public Binding bindingMoyFanoutExchangeC() {
        return BindingBuilder.bind(moyFanoutExchangeQueueC()).to(moyFanoutExchange());
    }
}
