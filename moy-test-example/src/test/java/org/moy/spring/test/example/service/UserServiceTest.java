package org.moy.spring.test.example.service;

import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * <p> 用户 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService service;

    @Test
    public void findAll() {
        List<UserEntity> result = service.findAll();
        assertTrue(result != null);
    }

    @Test
    public void insert() {
        UserEntity entity = new UserEntity();
        String uid = UUID.randomUUID().toString();
        service.delete(TEST_ID);
        entity.setId(TEST_ID);
        entity.setCode(uid);
        entity.setName(uid);
        Integer result = service.insert(entity);
        assertTrue(result == 1);
    }
}