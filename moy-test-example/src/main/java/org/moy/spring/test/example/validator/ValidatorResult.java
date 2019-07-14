package org.moy.spring.test.example.validator;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import java.util.Set;

/**
 * <p>Description: [自定义 校验结果]</p>
 * Created on 2019/06/27
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 墨阳
 */
public class ValidatorResult<T> implements Serializable {

    private Boolean validatorIsOk;
    private String errorMessage;
    private Set<ConstraintViolation<T>> validatorResult;


    public ValidatorResult(Boolean validatorIsOk, String errorMessage, Set<ConstraintViolation<T>> validatorResult) {
        this.validatorIsOk = validatorIsOk;
        this.errorMessage = errorMessage;
        this.validatorResult = validatorResult;
    }

    public Boolean validatorIsOk() {
        return validatorIsOk;
    }

    public Boolean validatorIsNotOk() {
        return !validatorIsOk();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Set<ConstraintViolation<T>> getValidatorResult() {
        return validatorResult;
    }

    @Override
    public String toString() {
        return "ValidatorResult{" +
                "validatorIsOk=" + validatorIsOk +
                ", errorMessage='" + errorMessage + '\'' +
                ", validatorResult=" + validatorResult +
                '}';
    }
}
