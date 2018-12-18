package org.moy.spring.feign.consumer;

import org.moy.spring.service.HelloServiceDefaultFallbackImpl;
import org.springframework.stereotype.Component;


/**
 * <p>Description: [HelloService 服务降级默认实现]</p>
 * Created on 2018/12/02
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class RefactorHelloServiceFallbackImpl extends HelloServiceDefaultFallbackImpl implements RefactorHelloService {
}
