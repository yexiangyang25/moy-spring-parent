package org.moy.spring.test.example.lock;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.config.Config;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2019/8/21
 *
 * @author <a href="mailto: yexiangyang@cn.wilmar-intl.com">叶向阳</a>
 * @version 1.0
 * Copyright (c) 2019 丰益（上海）信息技术有限公司
 */
public class RedissonConfigTest {


    @Test
    public void test() throws InterruptedException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RLock lock = redissonClient.getLock("myLock");
        boolean b = lock.tryLock();
        if (b) {
            System.out.println(Thread.currentThread().getId() + "--------->执行前获取到锁   状态:" + lock.isLocked());
            Thread.sleep(3 * 1000);
            Thread.sleep(5 * 60 * 1000 + 5);
            System.out.println(Thread.currentThread().getId() + "--------->执行后获取到锁   状态:" + lock.isLocked());
            lock.unlock();
        } else {
            System.err.println(Thread.currentThread().getId() + "--------->没有获取到锁     状态:" + lock.isLocked());
            lock.unlock();
        }
    }
}