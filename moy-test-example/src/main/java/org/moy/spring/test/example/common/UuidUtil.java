package org.moy.spring.test.example.common;

import java.util.UUID;

/**
 * <p>Description: [uuid 转化工具类]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public class UuidUtil {

    private UuidUtil() {
    }


    public static String newUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
