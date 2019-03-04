package org.moy.spring.test.example.domain;

import org.moy.spring.test.example.common.BaseEntity;
import org.moy.spring.test.example.common.JsonUtil;

import java.io.Serializable;

/**
 * <p>Description: [博客标签 实体]</p>
 * Created on 2019/3/4
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class TagEntity extends BaseEntity implements Serializable {

    private Long id;
    private String code;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
