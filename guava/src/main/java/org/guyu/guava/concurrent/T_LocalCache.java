package org.guyu.guava.concurrent;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * @author guyu03 <guyu03@kuaishou.com>
 * Created on 2020-10-19
 */
public class T_LocalCache {
    static LoadingCache<String, String> myCache = CacheBuilder.newBuilder()
            .maximumSize(2)
            .expireAfterWrite(10, TimeUnit.SECONDS)
            .build(
                    new CacheLoader<String, String>() {
                        @Override
                        public String load(String key) {
                            return getStrVal(key);
                        }
                    });

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            es.execute(()-> {
                try {
                    System.out.println(myCache.get("garry"));
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private static String getStrVal(String input) {
        System.out.println("getStrVal at: " + LocalDateTime.now());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return input + "_gy";
    }
}
