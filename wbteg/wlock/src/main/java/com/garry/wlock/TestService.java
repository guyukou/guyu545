package com.garry.wlock;

import com.bj58.spat.wlock.client.WDistributedLock;
import com.bj58.spat.wlock.client.WLockClient;
import com.bj58.spat.wlock.client.exception.ParameterIllegalException;
import com.bj58.spat.wlock.client.lockresult.AcquireLockResult;
import com.bj58.spat.wlock.starter.annotation.LockClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author guyu06
 * @date 2023/5/24 07:10
 */
@Component
public class TestService implements CommandLineRunner {
    @LockClient
    WLockClient wlockClient;


    @Override
    public void run(String... args) throws Exception {

        var executorService = Executors.newFixedThreadPool(10);
        WDistributedLock lock = wlockClient.newDistributeLock("test");
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {

                while (true) {
                    AcquireLockResult acquireLockResult = null;
                    try {
                        acquireLockResult = lock.tryAcquireLock(5000, 1000);
                    } catch (ParameterIllegalException e) {
                        throw new RuntimeException(e);
                    }
                    // 业务逻辑
                    try {
                        if (acquireLockResult.isSuccess()) {
                            TimeUnit.SECONDS.sleep(5);
                            System.out.println(Thread.currentThread().getName() + acquireLockResult.isSuccess());
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        lock.releaseLock();
                    } catch (ParameterIllegalException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

    }
}
