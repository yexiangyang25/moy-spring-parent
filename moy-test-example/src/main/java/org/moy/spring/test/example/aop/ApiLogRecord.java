package org.moy.spring.test.example.aop;

import org.moy.spring.test.example.common.JsonUtil;

import java.io.Serializable;

/**
 * <p>Description: [Log 日志收集]</p>
 * Created on 2019/5/20
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ApiLogRecord implements Serializable {
    private Long submitTime;
    private Long execTime;
    private Object[] args;
    private Object result;

    public static ApiLogRecord buildCallBefore(Object[] args, Long startTime) {
        ApiLogRecord apiLogRecord = ApiLogRecord.newDefaultValue();
        apiLogRecord.setArgs(args);
        apiLogRecord.setSubmitTime(startTime);
        return apiLogRecord;
    }

    public static void buildCallAfter(ApiLogRecord apiLogRecord, Long startTime, Object result) {
        apiLogRecord.setResult(result);
        long endTime = System.currentTimeMillis();
        apiLogRecord.setExecTime(endTime - startTime);
        // 收集日志
        LogCollect.collect(JsonUtil.toJsonString(apiLogRecord));
    }

    private static ApiLogRecord newDefaultValue() {
        return new ApiLogRecord();
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Long getExecTime() {
        return execTime;
    }

    public void setExecTime(Long execTime) {
        this.execTime = execTime;
    }

    public Long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Long submitTime) {
        this.submitTime = submitTime;
    }

    @Override
    public String toString() {
        return JsonUtil.toJsonString(this);
    }
}
