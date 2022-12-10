package com.guyu.unsafe;

import lombok.ToString;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.FutureTask;

@ToString
public class G_SetUseUnsafe {
    private int age;
    private String name;
    private boolean married;

    public static void main(String[] args) {
        G_SetUseUnsafe g = new G_SetUseUnsafe();
        System.out.printf("before set: %s\n", g);
        UNSAFE.compareAndSwapInt(g, ageOffset, 0, 31);
        UNSAFE.compareAndSwapObject(g, nameOffset, null, "garry");
        UNSAFE.compareAndSwapInt(g, marriedOffset, 0, 1); // swapInt可以用来设置boolean
//        UNSAFE.putBoolean(g, marriedOffset, false);
        System.out.printf("after set: %s\n", g);
    }

    private static final sun.misc.Unsafe UNSAFE;
    private static final long ageOffset;
    private static final long nameOffset;
    private static final long marriedOffset;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            UNSAFE = (Unsafe) f.get(null);
            Class<?> k = G_SetUseUnsafe.class;
            ageOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("age"));
            nameOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("name"));
            marriedOffset = UNSAFE.objectFieldOffset
                    (k.getDeclaredField("married"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
