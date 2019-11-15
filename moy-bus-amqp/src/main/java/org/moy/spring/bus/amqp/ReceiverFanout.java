package org.moy.spring.bus.amqp;


import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * <p>Description: [amqp 接受者]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class ReceiverFanout {

    private static Logger LOG = LoggerFactory.getLogger(ReceiverFanout.class);

    @RabbitListener(queues = RabbitmqConstants.MOY_FANOUT_EXCHANGE_QUEUE_A)
    @RabbitHandler
    public void processA(String context, Channel channel, Message message) throws IOException {
        boolean basicNack = true;
        try {
            LOG.info("Fanout A 正在处理消息: [" + context + " ],处理时间: " + System.currentTimeMillis());
            // 处理成功 确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            basicNack = false;
        } finally {
            if (basicNack) {
                // 处理失败 拒收消息
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

    @RabbitListener(queues = RabbitmqConstants.MOY_FANOUT_EXCHANGE_QUEUE_B)
    @RabbitHandler
    public void processB(String context, Channel channel, Message message) throws IOException {
        boolean basicNack = true;
        try {
            LOG.info("Fanout B 正在处理消息: [" + context + " ],处理时间: " + System.currentTimeMillis());
            // 处理成功 确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            basicNack = false;
        } finally {
            if (basicNack) {
                // 处理失败 拒收消息
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

    @RabbitListener(queues = RabbitmqConstants.MOY_FANOUT_EXCHANGE_QUEUE_C)
    @RabbitHandler
    public void processC(String context, Channel channel, Message message) throws IOException {
        boolean basicNack = true;
        try {
            LOG.info("Fanout C 正在处理消息: [" + context + " ],处理时间: " + System.currentTimeMillis());
            // 处理成功 确认消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            basicNack = false;
        } finally {
            if (basicNack) {
                // 处理失败 拒收消息
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }
}
