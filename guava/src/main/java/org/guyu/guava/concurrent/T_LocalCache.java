package org.guyu.guava.concurrent;

import java.time.LocalDateTime;
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
        for (int i = 0; i < 50; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(myCache.get("ggyy1"));
            System.out.println(myCache.get("ggyy2"));
        }
    }

    private static String getStrVal(String input) {
        System.out.println("getStrVal at: " + LocalDateTime.now());
        return input + "_gy";
    }
}
