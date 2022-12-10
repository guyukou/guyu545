package com.guyu.thread;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.guyu.util.LazyBoy;

import java.util.Random;
import java.util.concurrent.*;

public class G_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor consumers = new ThreadPoolExecutor(
                1, 1,
                0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactoryBuilder().setNameFormat("my thraed pool-%d").build(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        Stopwatch stopwatch = Stopwatch.createStarted();
        Future<String> submit = consumers.submit(() -> {
//            LazyBoy.sleepMS(new Random().nextInt(2000));
            LazyBoy.sleepMS(5000);
            return "ok";
        });
        Future<Integer> submit2 = consumers.submit(() -> {
            LazyBoy.sleepMS(5000);
            return 1;
        });
        System.out.printf("submit cost %d ms\n", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        Future<Boolean> submit3 = consumers.submit(() -> {
            LazyBoy.sleepMS(5000);
            return true;
        });
        String s = submit.get();
        Integer integer = submit2.get();
        Boolean aBoolean = submit3.get();

        System.out.printf("get cost %d ms\n", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        consumers.shutdownNow();

    }

}
