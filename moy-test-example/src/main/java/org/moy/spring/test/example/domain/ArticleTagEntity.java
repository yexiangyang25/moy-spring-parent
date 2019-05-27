package org.moy.spring.test.example.domain;

import org.moy.spring.test.example.common.JsonUtil;

import java.io.Serializable;

/**
 * <p>Description: [博客标签 实体]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ArticleTagEntity implements Serializable {
    private static final long serialVersionUID = 8935574563104607950L;

    private Long id;
    private String tagCode;
    private String articleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
