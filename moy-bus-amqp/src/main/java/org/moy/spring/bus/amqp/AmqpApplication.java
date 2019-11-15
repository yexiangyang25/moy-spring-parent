package org.moy.spring.bus.amqp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description: [amqp消息 应用入口]</p>
 * Created on 2018/12/09
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@SpringBootApplication
@RestController
public class AmqpApplication {

    @Autowired
    private Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }

    @GetMapping("/")
    public void send() {
        sender.send();
    }

    @GetMapping("/direct")
    public void sendDirect() {
        sender.sendDirect();
    }

    @GetMapping("/fanout")
    public void sendFanout() {
        sender.sendFanout();
    }
}
