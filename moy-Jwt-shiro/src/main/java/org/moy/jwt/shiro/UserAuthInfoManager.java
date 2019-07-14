package org.moy.jwt.shiro;

/**
 * <p>Description: [用户权限信息 适配接口]</p>
 * Created on 2018/12/19
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface UserAuthInfoManager {

    /**
     * 根据用户名称查询权限名
     * @return
     */
    UserAuthInfo getCurrentUserInfo();
}
