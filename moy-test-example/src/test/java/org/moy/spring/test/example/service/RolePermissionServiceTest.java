package org.moy.spring.test.example.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.common.JsonUtil;
import org.moy.spring.test.example.domain.RolePermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * <p> 权限 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class RolePermissionServiceTest extends BaseTest {

    @Autowired
    private RolePermissionService service;

    @Test
    public void findAll() {
        PageHelper.startPage(1, 10);
        List<RolePermissionEntity> entityList = service.findAll();
        PageResultBean<List<RolePermissionEntity>> result = PageResultBean.buildPageListToPageResult(entityList);
        LOG.info(JsonUtil.toJsonString(result));
        assertTrue(result.getSuccess());
    }

    @Test
    public void insert() {
        // 先删
        service.delete(TEST_ID);
        // 在保存
        RolePermissionEntity entity = new RolePermissionEntity();
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