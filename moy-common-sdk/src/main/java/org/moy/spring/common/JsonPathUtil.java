package org.moy.spring.common;

import com.alibaba.fastjson.*;
import org.moy.spring.pojo.Demo;

/**
 * <p>Description: [JSONPath 工具类]</p>
 * Created on 2019/9/29
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class JsonPathUtil {

    /**
     * 根据JSONPath路径获取对应值
     *
     * @param object
     * @param path
     * @return
     */
    public static String getStringFromJsonArray(Object object, String path) {
        if (null == object) {
            throw new IllegalArgumentException("object is null !");
        }
        JSONArray jsonArray = null;
        if (object instanceof JSONArray) {
            jsonArray = (JSONArray) object;
        } else if (object instanceof String) {
            jsonArray = JSON.parseArray((String) object);
        } else {
            jsonArray = JSON.parseArray(JSON.toJSONString(object));
        }
        if (JSONPath.contains(jsonArray, path)) {
            return String.valueOf(JSONPath.eval(jsonArray, path));
        } else {
            throw new IllegalArgumentException("not contains path : " + path);
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setPassword("setPassword");
        demo.setUsername("setUsername");
        String[] strings = {"233", "456"};
        Object o = new Object[]{1, "233", strings, demo};
        System.err.println(JSON.toJSONString(o));
        System.out.println(getStringFromJsonArray(o, "$[0]"));
        System.out.println(getStringFromJsonArray(o, "$[2][1]"));
        System.out.println(getStringFromJsonArray(o, "$[3].username"));
        System.out.println(getStringFromJsonArray(o, "$[3].password"));
    }
}
