package org.moy.spring.test.example.common;

import org.moy.spring.test.example.shiro.JwtSecurityUtils;
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

    public static void setUpdateNeedValue(BaseEntity baseEntity) {
        baseEntity.setOperateTime(new Date());
        baseEntity.setOperator(getCurrentUsername());
    }

    public static void setCreateAndUpdateNeedValue(BaseEntity baseEntity) {
        Date date = new Date();
        String currentUserName = getCurrentUsername();

        baseEntity.setCreateTime(date);
        baseEntity.setFounder(currentUserName);

        baseEntity.setOperator(currentUserName);
        baseEntity.setOperateTime(date);
    }

    public static String getCurrentUsername() {
        try {
            return JwtSecurityUtils.getCurrentUserName();
        } catch (Exception e) {
            LOG.error("get currentUserName exception", e);
        }
        return "unknown user";
    }
}
