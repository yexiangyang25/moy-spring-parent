package org.moy.spring.test.example.service;

import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.moy.spring.test.example.BaseTest;
import org.moy.spring.test.example.beans.PageResultBean;
import org.moy.spring.test.example.common.BaseEntityUtil;
import org.moy.spring.test.example.common.JsonUtil;
import org.moy.spring.test.example.common.UuidUtil;
import org.moy.spring.test.example.domain.ShowLoveWallOrderEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * <p> 用户 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
public class ShowLoveWallOrderServiceTest extends BaseTest {

    @Autowired
    private ShowLoveWallOrderService service;

    @Test
    public void findAll() {
        PageHelper.startPage(1, 10);
        List<ShowLoveWallOrderEntity> entityList = service.findAll();
        PageResultBean<List<ShowLoveWallOrderEntity>> result = PageResultBean.buildPageListToPageResult(entityList);
        LOG.info(JsonUtil.toJsonString(result));
        assertTrue(result.getSuccess());
    }

    @Test
    public void insert() {
        // 先删
        service.delete(TEST_ID);
        // 在保存
        ShowLoveWallOrderEntity entity = new ShowLoveWallOrderEntity();
        String uid =  UuidUtil.newUuid();
        entity.setId(TEST_ID);
        entity.setCode(uid);
        BaseEntityUtil.setCreateAndUpdateNeedValue(entity);
        LOG.info(entity.toString());
        Integer result = service.insert(entity);
        assertTrue(result == 1);
    }
}