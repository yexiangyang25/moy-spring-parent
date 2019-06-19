package org.moy.spring.test.example.common;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [基础 必须属性]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public abstract class BaseEntity implements Serializable {

    /**
     * 创建时间
     */
    protected Date createTime;
    /**
     * 创建人
     */
    protected String founder;
    /**
     * 更新人
     */
    protected String operator;
    /**
     * 更新时间
     */
    protected Date operateTime;

    protected Long version;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
