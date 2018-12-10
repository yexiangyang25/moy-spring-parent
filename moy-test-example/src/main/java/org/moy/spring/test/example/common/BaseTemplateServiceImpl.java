package org.moy.spring.test.example.common;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * <p>Description: [基础 接口模板实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public abstract class BaseTemplateServiceImpl<tRepository extends BaseRepository, T, PK extends Serializable> extends BaseService implements BaseTemplateService<T, PK> {

    private static final String BASE_REPOSITORY_NAME = "baseRepository";

    protected BaseRepository<T, PK> baseRepository;

    /**
     * 借助spring初始化bean时 执行
     *
     * @author 叶向阳
     */
    @PostConstruct
    @SuppressWarnings("unchecked")
    private void initBind() {
        // 获取继承该类的类名 即子类
        Class<? extends BaseTemplateService> subClass = this.getClass();
        try {
            ParameterizedType type = (ParameterizedType) subClass.getGenericSuperclass();
            // 获取子类第一个泛型参数 即数据库实体操作类
            Class<T> entityClazz = (Class<T>) type.getActualTypeArguments()[0];
            T bean = SpringContextUtil.getBean(entityClazz);
            // 将该实体操作类实例对象设置到baseRepository中
            Field baseField = subClass.getSuperclass().getDeclaredField(BASE_REPOSITORY_NAME);
            baseField.setAccessible(true);
            baseField.set(this, bean);
        } catch (Exception e) {
            String errorMsg = String.format("初始化业务操作类模板失败,[%s]必须申明三个泛型参数,1.%s,2.%s,3.%s",
                    subClass.getSimpleName(),
                    "第一个泛型形参为数据库实体操作类,",
                    "第二个泛型形参为数据库实体类,",
                    "第二个泛型形参为数据库实体名主键字段对应类型!");
            throw new RuntimeException(errorMsg, e);
        }
    }

    @Override
    public Integer insert(T entity) {
        return baseRepository.insert(entity);
    }

    @Override
    public Integer addAll(List<T> entity) {
        return baseRepository.addAll(entity);
    }

    @Override
    public Integer delete(PK id) {
        return baseRepository.delete(id);
    }

    @Override
    public Integer delete(T entity) {
        return baseRepository.delete(entity);
    }

    @Override
    public Integer deleteAll(List<PK> ids) {
        return baseRepository.deleteAll(ids);
    }

    @Override
    public Integer update(T entity) {
        return baseRepository.update(entity);
    }

    @Override
    public Integer updateAll(List<T> entity) {
        return baseRepository.updateAll(entity);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> query(T entity) {
        return baseRepository.query(entity);
    }

    @Override
    public T get(T entity) {
        return baseRepository.get(entity);
    }

    @Override
    public T get(PK id) {
        return baseRepository.get(id);
    }

    @Override
    public List<T> find(List<PK> ids) {
        return baseRepository.find(ids);
    }

    @Override
    public Long count() {
        return baseRepository.count();
    }

    @Override
    public Long count(T entity) {
        return baseRepository.count(entity);
    }
}
