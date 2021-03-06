package org.moy.spring.test.example.dto;

import org.hibernate.validator.constraints.Length;
import org.moy.spring.test.example.aop.MessageKeyConstants;
import org.moy.spring.common.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Description: [订单 实体]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public class OrderQueryDTO implements Serializable {

    private static final long serialVersionUID = -7975720552455136426L;
    @NotNull(message = MessageKeyConstants.MESSAGE_ARTICLE_PAGE)
    private Integer page;
    @NotNull(message = MessageKeyConstants.MESSAGE_ARTICLE_LIMIT)
    @Max(value = 15 , message = MessageKeyConstants.MESSAGE_ARTICLE_MAX)
    private Integer limit;
    @Length(max = 50 , message = MessageKeyConstants.MESSAGE_COMMON_QUERY_MAX)
    private String title;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
