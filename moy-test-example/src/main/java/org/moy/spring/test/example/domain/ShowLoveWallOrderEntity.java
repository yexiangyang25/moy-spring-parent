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
public class ShowLoveWallOrderEntity extends BaseEntity {

    private static final long serialVersionUID = -786944598088224755L;
    private Long id;
    private String code;
    private String date;
    private String mr;
    private String mrs;
    private String title;
    private String signature;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMrs() {
        return mrs;
    }

    public void setMrs(String mrs) {
        this.mrs = mrs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
