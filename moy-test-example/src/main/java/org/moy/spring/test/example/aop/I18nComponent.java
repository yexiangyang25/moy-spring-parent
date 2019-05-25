package org.moy.spring.test.example.aop;

import org.apache.commons.lang3.StringUtils;
import org.moy.spring.test.example.common.NullUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
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

    /**
     * 自定义获取当前请求国际化语言
     *
     * @return
     */
    public Locale getCurrentServletRequestRequestLocale() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
                HttpServletRequest request = servletRequestAttributes.getRequest();
                String lang = request.getParameter("lang");
                if (StringUtils.isNotEmpty(lang)) {
                    return new Locale(lang);
                }
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
        return getValidateMessage(getCurrentServletRequestRequestLocale(), objects);
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
                    if (NullUtil.collectionIsNotEmpty(set)) {
                        buildMessage(locale, builder, set);
                    }
                }
            }
        }

        return builder.toString();
    }

    private void buildMessage(Locale locale, StringBuilder builder, Set<ConstraintViolation<Object>> set) {
        boolean isFirst = true;
        for (ConstraintViolation each : set) {
            String messageTemplate = each.getMessageTemplate();
            if (StringUtils.isNotEmpty(messageTemplate)) {
                if (!isFirst) {
                    builder.append(";");
                } else {
                    isFirst = false;
                }
                String message = i18nMessage(messageTemplate, locale);
                ConstraintDescriptor<?> constraintDescriptor = each.getConstraintDescriptor();
                Map<String, Object> attributes = constraintDescriptor.getAttributes();
                Set<Map.Entry<String, Object>> entrySet = attributes.entrySet();
                if (NullUtil.collectionIsNotEmpty(entrySet)
                        && message.contains("{") && message.contains("}")) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        String formatKey = String.format("{%s}", entry.getKey());
                        if (message.contains(formatKey)) {
                            message = message.replace(formatKey, String.valueOf(entry.getValue()));
                        }
                    }
                }
                builder.append(message);
            }
        }
    }

    private String i18nMessage(String messageKey, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ValidationMessages", locale);
        if (resourceBundle.containsKey(messageKey)) {
            return resourceBundle.getString(messageKey);
        } else {
            LOG.error("can not find messageKey : {} , Locale: {}", messageKey, locale);
        }
        return "";
    }

    @Bean
    public Validator validator() {
        Validator validator = Validation.byDefaultProvider()
                .configure()
                .buildValidatorFactory()
                .getValidator();
        return validator;
    }
}
