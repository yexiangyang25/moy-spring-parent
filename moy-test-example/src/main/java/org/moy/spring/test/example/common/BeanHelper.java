package org.moy.spring.test.example.common;

import org.moy.spring.test.example.beans.PageResultBean;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [封装bean copy 工具]</p>
 * Created on 2018/12/17
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class BeanHelper {

    private BeanHelper() {
    }

    public static <T> T copyProperties(Object source, Class<T> clazz) {
        T t = ReflectUtil.newInstance(clazz);
        BeanUtils.copyProperties(source, t);
        return t;
    }


    public static <E, T> List<T> copyList(List<E> sourceList, Class<T> clazz) {
        if (NullUtil.collectionIsEmpty(sourceList)) {
            return new ArrayList<>(2);
        }

        List<T> result = new ArrayList<>(sourceList.size());
        for (E each : sourceList) {
            T t = copyProperties(each, clazz);
            result.add(t);
        }
        return result;
    }

    public static <E, T> PageResultBean<List<T>> copyPageList(PageResultBean<List<E>> sourcePageResultBean, Class<T> clazz) {
        List<E> data = sourcePageResultBean.getData();
        List<T> copyList = copyList(data, clazz);
        return PageResultBean.buildDTOPage(sourcePageResultBean, copyList);
    }
}
