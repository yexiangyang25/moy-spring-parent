package org.moy.spring.test.example.service;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.moy.jwt.shiro.JwtSecurityUtils;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.common.*;
import org.moy.spring.test.example.domain.PasswordEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * <p> 密码 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class PasswordServiceTest extends BaseTest {

    @Autowired
    private PasswordService service;

    @Test
    public void findAll() {
        PageHelper.startPage(1, 10);
        List<PasswordEntity> entityList = service.findAll();
        PageResultBean<List<PasswordEntity>> result = PageResultBean.buildPageListToPageResult(entityList);
        LOG.info(JsonUtil.toJsonString(result));
        assertTrue(result.getSuccess());
    }

    @Test
    public void insert() {
        // 先删
        service.delete(TEST_ID);
        // 在保存
        PasswordEntity entity = new PasswordEntity();
        String uid =  UuidUtil.newUuid();
        entity.setId(TEST_ID);
        entity.setCode(uid);
        entity.setUserCode(uid);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity,JwtSecurityUtils.getCurrentUserName());
        LOG.info(entity.toString());
        Integer result = service.insert(entity);
        assertTrue(result == 1);
    }
}