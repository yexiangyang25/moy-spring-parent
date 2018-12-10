package org.moy.spring.test.example.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>Description: [日志 记录]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public abstract class BaseLog {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
}
