package com.guyu.conc;

import com.guyu.util.LazyBoy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class G_CompletableFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            long start = System.currentTimeMillis();
            LazyBoy.sleepS(1);
            System.out.printf("I've slept for %d seconds\n", (System.currentTimeMillis() - start) / 1000);
        });
        voidCompletableFuture.get();
        System.out.println("done");

    }
}
