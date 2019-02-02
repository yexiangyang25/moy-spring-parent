package org.moy.spring.test.example.common;

import java.util.UUID;

/**
 * <p>Description: [uuid 转化工具类]</p>
 * Created on 2019/2/2
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
public class UuidUtil {

    private UuidUtil() {
    }


    public static String newUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
