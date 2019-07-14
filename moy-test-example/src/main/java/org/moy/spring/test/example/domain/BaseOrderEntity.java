package org.moy.spring.test.example.domain;


import org.moy.spring.common.*;


/**
 * <p>Description: [基础订单 实体]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class BaseOrderEntity extends BaseEntity {

    private Long id;
    private String orderNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
