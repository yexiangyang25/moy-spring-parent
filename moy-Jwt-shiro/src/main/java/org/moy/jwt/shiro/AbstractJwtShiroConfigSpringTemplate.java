package org.moy.jwt.shiro;


import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * <p>Description: [Shiro 配置]
 * </p>
 * Created on 2018/12/26
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public abstract class AbstractJwtShiroConfigSpringTemplate {

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，以为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager Filter Chain定义说明
     * 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager, JwtFilter jwtFilter) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setUnauthorizedUrl(JwtConst.UN_AUTH_URI);
        //验证码过滤器
        Map<String, Filter> filtersMap = shiroFilterFactoryBean.getFilters();
        filtersMap.put("jwt", jwtFilter);
        shiroFilterFactoryBean.setFilters(filtersMap);

        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 访问无权限页面
        filterChainDefinitionMap.put(JwtConst.UN_AUTH_URI, "anon");
        // 其他的
        filterChainDefinitionMap.put("/**", "jwt");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(JwtShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm
        securityManager.setRealm(shiroRealm);
        // 关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    /**
     * 身份认证realm
     */
    @Bean
    public JwtShiroRealm shiroRealm(JwtCacheManager jwtCacheManager, UserAuthInfoManager userAuthInfoManager) {
        JwtShiroRealm shiroRealm = new JwtShiroRealm(jwtCacheManager, userAuthInfoManager);
        return shiroRealm;
    }

    /**
     *  认证实现
     * @param stringRedisTemplate
     * @return
     */
    @Bean
    public abstract JwtCacheManager jwtCacheManager(StringRedisTemplate stringRedisTemplate);

    /**
     *  角色权限实现
     * @return
     */
    @Bean
    public abstract UserAuthInfoManager userAuthInfoManager();

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    /**
     * 开启shiro aop注解支持. 使用代理方式; 所以需要开启代码支持;
     *
     * @param securityManager 安全管理器
     * @return 授权Advisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
