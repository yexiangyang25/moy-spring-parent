package org.moy.spring.common;

import org.springframework.beans.factory.annotation.Autowired;

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
public abstract class BaseTemplateServiceImpl<tRepository extends BaseRepository, T, PK extends Serializable>
        extends BaseService implements BaseTemplateService<T, PK> {

    private static final String BASE_REPOSITORY_NAME = "baseRepository";

    protected BaseRepository<T, PK> baseRepository;
    /**
     * 避免SpringContextUtil未初始化
     */
    @Autowired
    protected SpringContextUtil springContextUtil;

    /**
     * 借助spring初始化bean时 执行
     *
     * @author 叶向阳
     */
    @PostConstruct
    @SuppressWarnings("unchecked")
    private void initBind() {
        // 获取当前继承该类的Class 即子类
        Class<? extends BaseTemplateService> subClass = this.getClass();
        try {
            ParameterizedType type = (ParameterizedType) subClass.getGenericSuperclass();
            // 获取子类第一个泛型参数 即数据库实体操作类
            Class<tRepository> entityRepositoryClazz = (Class<tRepository>) type.getActualTypeArguments()[0];
            Class<T> tClazz = (Class<T>) type.getActualTypeArguments()[1];

            LOG.info("初始化模板服务类={},数据访问类={},数据类={}", subClass.getName(), entityRepositoryClazz.getName(), tClazz.getName());
            tRepository bean = SpringContextUtil.getBean(entityRepositoryClazz);
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
    public Integer deleteByCondition(T entity) {
        return baseRepository.deleteByCondition(entity);
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
    public T getByCondition(T entity) {
        return baseRepository.getByCondition(entity);
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
    public Long countByCondition(T entity) {
        return baseRepository.countByCondition(entity);
    }
}
