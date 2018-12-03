package org.moy.spring.test.example.repository;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [基础 数据操作]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public interface BaseRepository<T, PK extends Serializable> {

    Integer insert(@Param("entity") T entity);

    Integer addAll(@Param("list") List<T> list);

    Integer delete(@Param("id") PK id);

    Integer delete(@Param("entity") T entity);

    Integer deleteAll(@Param("ids") List<PK> ids);

    Integer update(@Param("entity") T entity);

    Integer updateAll(@Param("list") List<T> entity);

    List<T> query(@Param("entity") T entity);

    List<T> findAll();

    T get(@Param("entity") T entity);

    T get(@Param("id") PK id);

    List<T> find(@Param("ids") List<PK> ids);

    Long count();

    Long count(@Param("entity") T entity);
}
