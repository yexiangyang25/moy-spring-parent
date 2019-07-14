package org.moy.spring.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * <p>Description: [Json转化 工具类]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JsonUtil {

    private JsonUtil(){}

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJsonString(T obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("convert POJO to JSON failure!", e);
        }
    }

    public static <T> T fromJsonString(String json, Class<T> type) {

        try {
            return OBJECT_MAPPER.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException("convert JSON to POJO failure!", e);
        }
    }

    public static <T> T fromJsonString(String json, TypeReference<T> valueTypeRef) {
        try {
            return OBJECT_MAPPER.readValue(json, valueTypeRef);
        } catch (Exception e) {
            throw new RuntimeException("convert JSON to POJO failure!", e);
        }
    }
}
