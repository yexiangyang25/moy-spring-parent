package aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class SemaphoreTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountDownLatchTest.class);

    public static void main(String[] args) {
        int threadNum = 200;
        Semaphore semaphore = new Semaphore(1);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadNum; i++) {
            int eachIndex = i;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire(30, TimeUnit.MICROSECONDS)) {
                        doSomething(eachIndex);
                        semaphore.release();
                    } else {
                        LOGGER.warn("wait resource fail");
                    }
                } catch (InterruptedException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            });
        }
        LOGGER.debug("finish");
        executorService.shutdown();
    }

    private static void doSomething(int threadNum) throws InterruptedException {
        Thread.sleep(30);
        LOGGER.info("{} : {}", Thread.currentThread().getName(), threadNum);
    }
}
