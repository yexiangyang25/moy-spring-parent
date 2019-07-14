package org.moy.spring.test.example.shiro;

import org.moy.jwt.shiro.AbstractJwtExceptionRestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>Description: [Rest 统一异常拦截]</p>
 * Created on 2018/12/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@RestControllerAdvice
public class JwtExceptionRestController extends AbstractJwtExceptionRestController {
}
