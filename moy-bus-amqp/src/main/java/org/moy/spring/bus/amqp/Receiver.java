package org.moy.spring.bus.amqp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * <p>Description: [amqp 接受者]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RabbitListener(queues = "hello")
@Component
public class Receiver {

    private static Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String hello) {
        LOG.info("Receiver: " + hello);
    }
}
