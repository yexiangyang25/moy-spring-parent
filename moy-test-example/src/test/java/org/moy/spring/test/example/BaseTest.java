package org.moy.spring.test.example;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p> 功能测试
 * Created on 2018/9/10
 *
 * @author 叶向阳
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public abstract class BaseTest {

    public static final Long TEST_ID = 1L;
}
