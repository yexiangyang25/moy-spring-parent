package org.moy.spring.test.example.service.impl;

import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.PasswordEntity;
import org.moy.spring.test.example.repository.PasswordRepository;
import org.moy.spring.test.example.service.PasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>Description: [密码 接口实现]</p>
 * Created on 2018/10/10
 *
 * @author <a href="mailto: moy25@foxmail.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2018 墨阳
 */
@Service
public class PasswordServiceImpl extends BaseTemplateServiceImpl<PasswordRepository, PasswordEntity, Long> implements PasswordService {

    @Resource
    private PasswordRepository passwordRepository;

    @Override
    public Boolean checkUserCodeAndPasswordIsOk(String userCode, String password) {
        PasswordEntity passwordEntity = new PasswordEntity();
        passwordEntity.setUserCode(userCode);
        passwordEntity.setCode(password);
        List<PasswordEntity> queryResult = passwordRepository.query(passwordEntity);
        if (NullUtil.collectionIsNotEmpty(queryResult)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
