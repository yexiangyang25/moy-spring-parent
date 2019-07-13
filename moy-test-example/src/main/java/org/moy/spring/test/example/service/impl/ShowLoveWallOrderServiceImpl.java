package org.moy.spring.test.example.service.impl;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.ShowLoveWallOrderEntity;
import org.moy.spring.test.example.repository.ShowLoveWallOrderRepository;
import org.moy.spring.test.example.service.ShowLoveWallOrderService;
import org.springframework.stereotype.Service;



/**
 * <p>Description: [表白墙 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class ShowLoveWallOrderServiceImpl extends BaseTemplateServiceImpl<ShowLoveWallOrderRepository, ShowLoveWallOrderEntity, Long> implements ShowLoveWallOrderService {
}
