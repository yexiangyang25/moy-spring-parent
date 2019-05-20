package org.moy.spring.test.example.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Description: [Log 日志收集]</p>
 * Created on 2019/5/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class LogCollect {

    private LogCollect() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(LogCollect.class);

    public static void collect(String log) {
        LOGGER.info(log);
    }
}
