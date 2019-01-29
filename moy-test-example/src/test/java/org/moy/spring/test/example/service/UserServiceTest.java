package org.moy.spring.test.example.service;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.common.JsonUtil;
import org.moy.spring.test.example.domain.UserEntity;
import org.moy.spring.test.example.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
        PageHelper.startPage(1, 10);
        List<UserEntity> entityList = service.findAll();
        PageResultBean<List<UserEntity>> result = PageResultBean.buildPageListToPageResult(entityList);
        LOG.info(JsonUtil.toJsonString(result));
        assertTrue(result.getSuccess());
    }

    @Test
    public void insert() {
        // 先删
        service.delete(TEST_ID);
        // 在保存
        UserEntity entity = new UserEntity();
        String uid = UUID.randomUUID().toString();
        entity.setId(TEST_ID);
        entity.setCode(uid);
        entity.setName(uid);
        Date date = new Date();
        entity.setCreateTime(date);
        entity.setModifyTime(date);
        entity.setOperateTime(date);
        entity.setOperator(TEST_ID.toString());
        entity.setStatus(1);
        entity.setTelephone("132");
        LOG.info(entity.toString());
        Integer result = service.insert(entity);
        assertTrue(result == 1);
    }

    @Test
    public void insertAll() {
        int i = 0;
        while (i++ < 100) {
            insert();
        }
    }
}