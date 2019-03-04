package org.moy.spring.test.example.dto;

import org.hibernate.validator.constraints.Length;
import org.moy.spring.test.example.common.JsonUtil;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [博客文章查询 实体]</p>
 * Created on 2019/1/31
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
public class ArticleQueryDTO implements Serializable {

    private static final long serialVersionUID = -7975720552455136426L;
    @NotNull(message = "{message.request.page}")
    private Integer page;
    @NotNull(message = "{message.request.limit}")
    @Max(15)
    private Integer limit;
    private String keyword;
    private String tag;

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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
