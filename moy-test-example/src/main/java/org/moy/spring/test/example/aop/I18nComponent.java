package org.moy.spring.test.example.aop;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

/**
 * <p>Description: [国际化支持]</p>
 * Created on 2018/12/18
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Component
public class I18nComponent {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private Validator validator;

    @Autowired
    private MessageInterpolator messageInterpolator;

    /**
     * 获取当前请求国际化语言
     *
     * @return
     */
    public Locale getCurrentRequestLocale() {
        try {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String lang = request.getParameter("lang");
            if (StringUtils.isNotEmpty(lang)) {
                return new Locale(lang);
            }
        } catch (Exception e) {
            LOG.error("get current request locale exception", e);
        }
        return Locale.CHINA;
    }

    /**
     * 获取当前请求国际化校验信息
     *
     * @param objects
     * @return
     */
    public String getValidateMessage(Object... objects) {
        return getValidateMessage(getCurrentRequestLocale(), objects);
    }

    /**
     * 获取国际化校验信息
     *
     * @param locale
     * @param objects
     * @return
     */
    public String getValidateMessage(Locale locale, Object... objects) {
        StringBuilder builder = new StringBuilder();
        if (null != objects) {
            for (Object object : objects) {
                if (null != object) {
                    Set<ConstraintViolation<Object>> set = validator.validate(object);
                    if (null != set && !set.isEmpty()) {
                        boolean isFirst = true;
                        for (ConstraintViolation each : set) {
                            String messageTemplate = each.getMessageTemplate();
                            if (StringUtils.isNotEmpty(messageTemplate)) {
                                if (!isFirst) {
                                    builder.append(";");
                                } else {
                                    isFirst = false;
                                }
                                builder.append(messageInterpolator.interpolate(messageTemplate, null, locale));
                            }
                        }
                    }
                }
            }
        }

        return builder.toString();
    }

    @Bean
    public MessageInterpolator messageInterpolator() {
        return new ResourceBundleMessageInterpolator(
                new PlatformResourceBundleLocator("ValidationMessages")
        );
    }

    @Bean
    public Validator validator() {
        Validator validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(messageInterpolator())
                .buildValidatorFactory()
                .getValidator();

        return validator;
    }
}
