package org.moy.spring.common;

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

    /**
     * 新增
     * @param entity
     * @return
     */
    Integer insert(@Param("entity") T entity);

    /**
     * 批量新增
     * @param list
     * @return
     */
    Integer addAll(@Param("list") List<T> list);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    Integer delete(@Param("id") PK id);

    /**
     * 根据条件删除
     * @param entity
     * @return
     */
    Integer deleteByCondition(@Param("entity") T entity);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Integer deleteAll(@Param("ids") List<PK> ids);

    /**
     * 更新
     * @param entity
     * @return
     */
    Integer update(@Param("entity") T entity);

    /**
     * 批量更新
     * @param entity
     * @return
     */
    Integer updateAll(@Param("list") List<T> entity);

    /**
     * 条件查询
     * @param entity
     * @return
     */
    List<T> query(@Param("entity") T entity);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();

    /**
     * 条件查询单个记录
     * @param entity
     * @return
     */
    T getByCondition(@Param("entity") T entity);

    /**
     * 主键查询
     * @param id
     * @return
     */
    T get(@Param("id") PK id);

    /**
     * 主键批量查询
     * @param ids
     * @return
     */
    List<T> find(@Param("ids") List<PK> ids);

    /**
     * 总计个数
     * @return
     */
    Long count();

    /**
     * 条件总计
     * @param entity
     * @return
     */
    Long countByCondition(@Param("entity") T entity);
}
