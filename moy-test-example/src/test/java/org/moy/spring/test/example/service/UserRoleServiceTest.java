package org.moy.spring.test.example.service;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.moy.jwt.shiro.JwtSecurityUtils;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.UserRoleEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        PageHelper.startPage(1, 10);
        List<UserRoleEntity> entityList = service.findAll();
        PageResultBean<List<UserRoleEntity>> result = PageResultBean.buildPageListToPageResult(entityList);
        LOG.info(JsonUtil.toJsonString(result));
        assertTrue(result.getSuccess());
    }

    @Test
    public void insert() {
        // 先删
        service.delete(TEST_ID);
        // 在保存
        UserRoleEntity entity = new UserRoleEntity();
        String uid = UuidUtil.newUuid();
        entity.setId(TEST_ID);
        entity.setUserCode(uid);
        entity.setRoleCode(uid);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity,JwtSecurityUtils.getCurrentUserName());
        LOG.info(entity.toString());
        Integer result = service.insert(entity);
        assertTrue(result == 1);
    }
}