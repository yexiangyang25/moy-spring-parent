package org.moy.spring.bus.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

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
        String context = getContext();
        LOG.info("Sender : " + context);
        amqpTemplate.convertAndSend(RabbitmqConstants.MOY_QUEUE, context);
    }

    public void sendFanout() {
        String context = getContext();
        LOG.info("sendFanout : " + context);
        amqpTemplate.convertAndSend(RabbitmqConstants.MOY_FANOUT_EXCHANGE, null, context);
    }

    public void sendDirect() {
        String context = getContext();
        LOG.info("sendDirect : " + context);
        amqpTemplate.convertAndSend(RabbitmqConstants.MOY_DIRECT_EXCHANGE, RabbitmqConstants.MOY_DIRECT_EXCHANGE_ROUTING_KEY, context);
    }

    private String getContext() {
        return String.format("id=%s ,threadName=%s ,threadId=%s  time=%s ! ",
                UUID.randomUUID().toString(),
                Thread.currentThread().getName(),
                Thread.currentThread().getId(),
                System.currentTimeMillis());
    }
}
