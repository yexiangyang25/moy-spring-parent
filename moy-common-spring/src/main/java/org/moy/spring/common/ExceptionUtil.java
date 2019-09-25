package org.moy.spring.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>Description: [基础异常工具类]</p>
 * Created on 2019/05/04
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
public class ExceptionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtil.class);
    private static final String CLASS_PATH_BASE_NAME = "message/ExceptionMessages";
    private static final Locale DEFAULT_LOCALE = new Locale("zh");
    public static final String DEFAULT_EXCEPTION_CODE = ExceptionCode.E50000;

    private ExceptionUtil() {
    }

    public static void newBusinessException(String msg) {
        throw new BusinessException(msg);
    }

    public static void newBusinessException(Integer code, String msg) {
        throw new BusinessException(code, msg);
    }

    /**
     * 编码获取信息
     *
     * @param code
     * @param args
     * @return
     */
    public static String i18nMessage(String code, String... args) {
        return i18nMessage(code, DEFAULT_LOCALE, args);
    }

    /**
     * 读取异常消息信息
     *
     * @param messageKey
     * @param locale
     * @return
     */
    public static String i18nMessage(String messageKey, Locale locale, String... args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(CLASS_PATH_BASE_NAME, locale);
        if (resourceBundle.containsKey(messageKey)) {
            String value = resourceBundle.getString(messageKey);
            if (null != args && args.length > 0) {
                MessageFormat mf = new MessageFormat(value);
                return mf.format(args);
            } else {
                return value;
            }

        } else {
            LOGGER.error("can not find messageKey : {} , Locale: {}", messageKey, locale);
        }
        return messageKey;
    }

    /**
     * 获取异常堆栈信息
     *
     * @param throwable
     * @return
     */
    public static String getStackTraceString(Throwable throwable) {
        if (null == throwable) {
            return null;
        }
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(i18nMessage(ExceptionCode.E50000));
        try {
            newBusinessException(ExceptionCode.E50000);
        } catch (Exception e) {
            System.out.println(getStackTraceString(e));
        }
    }
}
