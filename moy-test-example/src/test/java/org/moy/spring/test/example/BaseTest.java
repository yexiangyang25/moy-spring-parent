package org.moy.spring.test.example;

import org.junit.runner.RunWith;
import org.moy.spring.test.example.common.BaseLog;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p> 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
@SpringBootTest(classes={ExampleApplication.class})
@RunWith(SpringRunner.class)
public abstract class BaseTest extends BaseLog {

    public static final Long TEST_ID = 1L;
}
