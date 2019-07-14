package org.moy.spring.test.example.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <p>Description: [自定义 校验注解]</p>
 * Created on 2019/06/27
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
@Constraint(validatedBy = StringNumberValidator.class) //具体的实现类
@Target({java.lang.annotation.ElementType.FIELD})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface StringNumber {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    //下面属性必须添加
    String message() default "不能转化为数字或者超过最大值:{max},小于最小值:{min}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
