package aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class CountDownLatchTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountDownLatchTest.class);

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 200;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadNum; i++) {
            int eachIndex = i;
            executorService.execute(() -> {
                try {
                    doSomething(eachIndex);
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(), e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        LOGGER.debug("finish");
        executorService.shutdown();
    }

    private static void doSomething(int threadNum) throws InterruptedException {
        Thread.sleep(100);
        LOGGER.info("{} : {}", Thread.currentThread().getName(), threadNum);
    }
}
