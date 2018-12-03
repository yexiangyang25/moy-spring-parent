package org.moy.spring.test.example.service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [基础 接口]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface BaseTemplateService<T, PK extends Serializable> {

    Integer insert(T entity);

    Integer addAll(List<T> entity);

    Integer delete(PK id);

    Integer delete(T entity);

    Integer deleteAll(List<PK> ids);

    Integer update(T entity);

    Integer updateAll(List<T> entity);

    List<T> findAll();

    List<T> query(T entity);

    T get(T entity);

    T get(PK id);

    List<T> find(List<PK> ids);

    Long count();

    Long count(T entity);
}
