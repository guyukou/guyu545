package com.guyu.conc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class G_ForkJoinPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new SumTask(1, 10000000));
        System.out.println(submit.get());
        System.out.println(forkJoinPool.getPoolSize());
    }

}
class SumTask extends RecursiveTask<Integer> {
    int bg;
    int ed;

    public SumTask(int bg, int ed) {
        this.bg = bg;
        this.ed = ed;
    }

    @Override
    protected Integer compute() {
        if (ed - bg >= 10) {
            int mid = bg + (ed - bg) / 2;
            SumTask task1 = new SumTask(bg, mid);
            SumTask task2 = new SumTask(mid+1, ed);
//                task1.fork();
//                task2.fork();
            invokeAll(task1, task2);
            return task1.join() + task2.join();
        }
        int sum = 0;
        for (int i = bg; i <= ed; i++) {
            sum += i;
        }
        return sum;
    }
}
