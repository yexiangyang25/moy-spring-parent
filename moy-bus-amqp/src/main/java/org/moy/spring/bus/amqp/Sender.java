package org.moy.spring.bus.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>Description: [amqp 发送者]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class Sender {

    private static Logger LOG = LoggerFactory.getLogger(Sender.class);
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = String.format("%s - %s : %s ! ",
                Thread.currentThread().getName(),
                Thread.currentThread().getId(),
                System.currentTimeMillis());
        LOG.info("Sender : " + context);
        this.amqpTemplate.convertAndSend(RabbitmqConstants.MOY_QUEUE, context);
    }

}
