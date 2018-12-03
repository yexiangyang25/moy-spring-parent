package org.moy.spring.feign.consumer;


import org.moy.spring.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;


/**
 * <p>Description: [代理应用]</p>
 * Created on 2018/12/02
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@FeignClient("moy-eureka-client")
@Service
public interface RefactorHelloService extends HelloService {
}
