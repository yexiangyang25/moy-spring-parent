package org.moy.spring.test.example.beans;

import java.io.Serializable;

/**
 * <p>Description: [统一 返回结果]</p>
 * Created on 2018/12/18
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS_CODE = 200;
    public static final Integer FAIL_CODE = 50;
    public static final String SUCCESS_MESSAGE = "success";
    public static final String FAIL_MESSAGE = "fail";

    protected Boolean success;
    protected Integer code;
    protected String msg;
    protected T data;

    protected ResultBean() {
    }

    protected ResultBean(Boolean success, Integer code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <E> ResultBean<E> success() {
        return success(null);
    }

    public static <E> ResultBean<E> success(E data) {
        return success(SUCCESS_MESSAGE, data);
    }

    public static <E> ResultBean<E> success(String message, E data) {
        return success(SUCCESS_CODE, message, data);
    }

    public static <E> ResultBean<E> success(Integer code, String message, E data) {
        return new ResultBean<>(true, code, message, data);
    }

    public static <E> ResultBean<E> newUnAuthResult() {
        return new ResultBean<>(false, 404, "您没有该操作权限！", null);
    }

    public static <E> ResultBean<E> newNotLoginResult() {
        return new ResultBean<>(false, 302, "本次登录失效，请重新登录", null);
    }

    public static <E> ResultBean<E> newFirendResult() {
        String message = "系统开小差了，请稍候再试";
        return ResultBean.fail(message);
    }

    public static <E> ResultBean<E> fail() {
        return fail(FAIL_MESSAGE);
    }

    public static <E> ResultBean<E> fail(String message) {
        return fail(FAIL_CODE, message);
    }

    public static <E> ResultBean<E> fail(Integer code, String message) {
        return fail(code, message, null);
    }

    public static <E> ResultBean<E> fail(Integer code, String message, E data) {
        return new ResultBean<>(false, code, message, data);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
