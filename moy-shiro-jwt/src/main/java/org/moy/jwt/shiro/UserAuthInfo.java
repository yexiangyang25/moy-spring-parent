package org.moy.jwt.shiro;


import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [用户权限信息]</p>
 * Created on 2018/12/31
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface UserAuthInfo  extends Serializable {

     /**
      * 角色集
      * @return
      */
     List<String> getRoles();

     /**
      * 权限集
      * @return
      */
     List<String> getPermissions() ;
}
