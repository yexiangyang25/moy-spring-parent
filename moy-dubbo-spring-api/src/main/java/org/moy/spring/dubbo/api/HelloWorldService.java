package org.moy.spring.dubbo.api;

/**
 * <p>Description: [定义接口]</p>
 * Created on 2019/8/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface HelloWorldService {

    /**
     * 定义
     * @param name
     * @return
     */
    String sayHi(String name);

    /**
     * 定义
     * @return
     */
    String sayHellWorld();
}
