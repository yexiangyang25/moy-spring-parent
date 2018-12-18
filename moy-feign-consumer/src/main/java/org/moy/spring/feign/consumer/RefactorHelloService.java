package org.moy.spring.feign.consumer;

import org.moy.spring.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * <p>Description: [反向代理应用服务]</p>
 * Created on 2018/12/02
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@FeignClient(value = "moy-eureka-client", fallback = RefactorHelloServiceFallbackImpl.class)
public interface RefactorHelloService extends HelloService {
}
