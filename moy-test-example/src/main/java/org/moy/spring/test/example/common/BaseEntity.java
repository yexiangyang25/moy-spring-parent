package org.moy.spring.test.example.common;

import java.util.Date;

/**
 * <p>Description: [基础 必须属性]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public abstract class BaseEntity{

    protected Date createTime;
    protected Date modifyTime;
    protected String operator;
    protected Date operateTime;

    protected Long version;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", operator='" + operator + '\'' +
                ", operateTime=" + operateTime +
                ", version=" + version +
                '}';
    }
}
