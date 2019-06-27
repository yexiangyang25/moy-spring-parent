package org.moy.spring.test.example.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>Description: [自定义 校验注解实现]</p>
 * Created on 2019/06/27
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public class StringNumberValidator implements ConstraintValidator<StringNumber, String> {
    int min;
    int max;

    @Override
    public void initialize(StringNumber constraint) {
        min = constraint.min();
        max = constraint.max();
    }

    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(obj)) {
            return true;
        }

        if (!StringUtils.isNumeric(obj)) {
            return false;
        }

        Integer integer = Integer.valueOf(obj);

        if (integer < min || integer > max) {
            return false;
        }
        return false;
    }
}
