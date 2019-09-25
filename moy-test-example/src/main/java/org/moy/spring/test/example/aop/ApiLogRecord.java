package org.moy.spring.test.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.moy.spring.common.JsonUtil;

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
    private static final long serialVersionUID = -8545283884267261438L;
    private Long submitTime;
    private String serverName;
    private Long execTime;
    private Object[] args;
    private Object result;
    private String exceptionStackTraceString;

    public static ApiLogRecord buildCallBefore(JoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        ApiLogRecord apiLogRecord = newDefaultValue();
        apiLogRecord.setArgs(joinPoint.getArgs());
        Signature signature = joinPoint.getSignature();
        String simpleName = signature.getDeclaringTypeName();
        String packageSplitter = ".";
        if (simpleName.contains(packageSplitter)) {
            simpleName = simpleName.substring(simpleName.lastIndexOf(packageSplitter) + packageSplitter.length());
        }
        apiLogRecord.setServerName(simpleName + packageSplitter + signature.getName());
        apiLogRecord.setSubmitTime(startTime);
        return apiLogRecord;
    }

    public static void buildCallAfter(ApiLogRecord apiLogRecord, Object result) {
        apiLogRecord.setResult(result);
        long endTime = System.currentTimeMillis();
        apiLogRecord.setExecTime(endTime - apiLogRecord.getSubmitTime());
        // 收集日志
        LogCollect.collect(JsonUtil.toJsonString(apiLogRecord));
    }

    public String getExceptionStackTraceString() {
        return exceptionStackTraceString;
    }

    public void setExceptionStackTraceString(String exceptionStackTraceString) {
        this.exceptionStackTraceString = exceptionStackTraceString;
    }

    private static ApiLogRecord newDefaultValue() {
        return new ApiLogRecord();
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
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
