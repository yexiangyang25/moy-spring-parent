package org.moy.spring.test.example.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.common.JsonUtil;
import org.moy.spring.test.example.domain.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * <p> 用户权限关系 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class UserRoleServiceTest extends BaseTest {

    @Autowired
    private UserRoleService service;

    @Test
    public void findAll() {
        PageHelper.startPage(2, 10);
        List<UserRoleEntity> result = service.findAll();
        PageInfo<UserRoleEntity> pageResult = PageInfo.of(result);
        LOG.info(JsonUtil.toJsonString(pageResult));
        assertTrue(result != null);
    }

    @Test
    public void insert() {
        // 先删
        service.delete(TEST_ID);
        // 在保存
        UserRoleEntity entity = new UserRoleEntity();
        String uid = UUID.randomUUID().toString();
        entity.setId(TEST_ID);
        Date date = new Date();
        entity.setCreateTime(date);
        entity.setModifyTime(date);
        entity.setOperateTime(date);
        entity.setOperator(TEST_ID.toString());
        LOG.info(entity.toString());
        Integer result = service.insert(entity);
        assertTrue(result == 1);
    }
}