package org.moy.spring.test.example.validator;

import org.apache.commons.lang3.StringUtils;
import org.moy.spring.common.NullUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
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

    private static final Logger LOG = LoggerFactory.getLogger(I18nComponent.class);
    private static final String CLASS_PATH_BASE_NAME = "ValidationMessages";
    private static final String REQUEST_LOCALE_LANGUAGE_KEY = "language";
    @Autowired
    private Validator validator;

    /**
     * 自定义获取当前请求国际化语言
     *
     * @return
     */
    private Locale getCurrentServletRequestRequestLocale() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if (requestAttributes instanceof ServletRequestAttributes) {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
                HttpServletRequest request = servletRequestAttributes.getRequest();
                // from request head
                String languageHeader = request.getHeader(REQUEST_LOCALE_LANGUAGE_KEY);
                if (StringUtils.isNotEmpty(languageHeader)) {
                    return new Locale(languageHeader);
                }
                // from request Cookie
                Cookie[] cookies = request.getCookies();
                if (null != cookies) {
                    for (Cookie cookie : cookies) {
                        if (REQUEST_LOCALE_LANGUAGE_KEY.equalsIgnoreCase(cookie.getName())) {
                            return new Locale(cookie.getValue());
                        }
                    }
                }
                // from request parameter
                String lang = request.getParameter(REQUEST_LOCALE_LANGUAGE_KEY);
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
     * @param obj    被校验对象
     * @param groups 多个校验组
     * @param <T>    校验数据对象类型
     * @return 返回校验结果
     */
    public <T> ValidatorResult<T> getValidateResult(T obj, Class<?>... groups) {
        // 获取当前请求国际化校验信息
        return getValidateResult(getCurrentServletRequestRequestLocale(), obj, groups);
    }

    /**
     * 校验数据对象
     *
     * @param locale 国际化
     * @param obj    被校验对象
     * @param groups 多个校验组
     * @param <T>    校验数据对象类型
     * @return 返回校验结果
     */
    public <T> ValidatorResult<T> getValidateResult(Locale locale, T obj, Class<?>... groups) {
        if (null != obj) {
            Set<ConstraintViolation<T>> set = validator.validate(obj, groups);
            if (NullUtil.collectionIsNotEmpty(set)) {
                String message = buildMessage(locale, set);
                return new ValidatorResult<>(false, message, set);
            }
        } else {
            LOG.warn("validate object is null!");
        }
        return new ValidatorResult<>(true, null, null);
    }

    private static <T> String buildMessage(Locale locale, Set<ConstraintViolation<T>> set) {
        StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (ConstraintViolation each : set) {
            if (!isFirst) {
                builder.append(";");
            } else {
                isFirst = false;
            }
            String message = (null == locale) ? each.getMessage() : buildLocaleMessage(locale, each);
            builder.append(message);
        }
        return builder.toString();
    }

    private static String buildLocaleMessage(Locale locale, ConstraintViolation each) {
        String message = "";
        String leftPlaceholder = "{";
        String rightPlaceholder = "}";
        String messageTemplate = each.getMessageTemplate();
        if (StringUtils.isNotEmpty(messageTemplate)) {
            message = i18nMessage(messageTemplate, locale);
            // 消息值包含{}占位符 则替换成元数据
            if (message.contains(leftPlaceholder) && message.contains(rightPlaceholder)) {
                ConstraintDescriptor<?> constraintDescriptor = each.getConstraintDescriptor();
                Map<String, Object> attributes = constraintDescriptor.getAttributes();
                Set<Map.Entry<String, Object>> entrySet = attributes.entrySet();
                if (NullUtil.collectionIsNotEmpty(entrySet)) {
                    for (Map.Entry<String, Object> entry : entrySet) {
                        String formatKey = String.format("{%s}", entry.getKey());
                        if (message.contains(formatKey)) {
                            message = message.replace(formatKey, String.valueOf(entry.getValue()));
                        }
                    }
                }
            }
        }
        return message;
    }

    private static String i18nMessage(String messageKey, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(CLASS_PATH_BASE_NAME, locale);
        if (resourceBundle.containsKey(messageKey)) {
            return resourceBundle.getString(messageKey);
        } else {
            LOG.error("can not find messageKey : {} , Locale: {}", messageKey, locale);
        }
        return messageKey;
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
