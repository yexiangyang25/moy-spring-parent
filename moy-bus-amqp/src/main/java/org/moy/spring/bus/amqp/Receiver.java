package org.moy.spring.bus.amqp;


import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;


/**
 * <p>Description: [amqp 接受者]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
@RabbitListener(queues = RabbitmqConstants.MOY_QUEUE)
public class Receiver {

    private static Logger LOG = LoggerFactory.getLogger(Receiver.class);

    @RabbitHandler
    public void process(String hello, Channel channel, Message message) throws IOException {
        LOG.info("正在处理消息: [" + hello + " ],处理时间: " + System.currentTimeMillis());
        try {
            int two = 2;
            int nextInt = new Random().nextInt(two);
            if (nextInt % two == 0) {
                throw new IOException();
            }
            LOG.info("receiver success");
            // 处理成功 确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (IOException e) {
            LOG.error("receiver fail", e);
            // 处理失败 拒收消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}
