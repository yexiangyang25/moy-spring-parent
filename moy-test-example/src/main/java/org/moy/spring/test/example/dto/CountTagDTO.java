package org.moy.spring.test.example.dto;

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
public class CountTagDTO implements Serializable {

    private String code;
    private Integer count;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
