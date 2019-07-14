package org.moy.spring.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * <p>Description: [基础 必须属性工具类]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public class BaseEntityUtil {

    private static final Logger LOG = LoggerFactory.getLogger(BaseEntityUtil.class);

    private BaseEntityUtil() {
    }

    public static void setUpdateNeedValue(BaseEntity baseEntity, String currentUserName) {
        baseEntity.setOperateTime(new Date());
        baseEntity.setOperator(currentUserName);
    }

    public static void setCreateAndUpdateNeedValue(BaseEntity baseEntity, String currentUserName) {
        Date date = new Date();
        baseEntity.setCreateTime(date);
        baseEntity.setFounder(currentUserName);

        baseEntity.setOperator(currentUserName);
        baseEntity.setOperateTime(date);
    }
}
