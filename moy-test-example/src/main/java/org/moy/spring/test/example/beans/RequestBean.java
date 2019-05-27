package org.moy.spring.test.example.beans;

import org.moy.spring.test.example.aop.MessageKeyConstants;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>Description: [请求 实体]</p>
 * Created on 2019/1/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class RequestBean<T> implements Serializable {
    private static final long serialVersionUID = -7973290052750261134L;

    @NotBlank(message = MessageKeyConstants.MESSAGE_REQUEST_SOURCE)
    private String source;
    @NotNull(message = MessageKeyConstants.MESSAGE_REQUEST_REQUEST)
    @Valid
    private T request;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "RequestBean{" +
                "source='" + source + '\'' +
                ", request=" + request +
                '}';
    }
}
