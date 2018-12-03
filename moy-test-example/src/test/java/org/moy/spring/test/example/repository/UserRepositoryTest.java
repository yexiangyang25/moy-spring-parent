package org.moy.spring.test.example.repository;

import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.domain.UserEntity;

import javax.annotation.Resource;

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
public class UserRepositoryTest extends BaseTest {

    @Resource
    private UserRepository repository;

    @Test
    public void findAll() {
        List<UserEntity> result = repository.findAll();
        assertTrue(result != null);
    }

    @Test
    public void insert() {
        UserEntity entity = new UserEntity();
        String uid = UUID.randomUUID().toString();
        repository.delete(TEST_ID);
        entity.setId(TEST_ID);
        entity.setCode(uid);
        entity.setName(uid);
        Integer result = repository.insert(entity);
        assertTrue(result == 1);
    }

}