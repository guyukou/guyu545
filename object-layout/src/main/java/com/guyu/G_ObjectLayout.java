package com.guyu;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author guyu03
 * Created on 2021-07-08
 */
public class G_ObjectLayout {
    public static void main(String[] args) {

//        vm_details();
//        simpleIntLayoutClass();
        simpleIntLayoutObject();
//        fieldArrangement();
//        age();
//        array();
    }

    /**
     * [Z object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0     4           (object header)                           01 00 00 00 (00000001 00000000 00000000
     *       4     4           (object header)                           00 00 00 00 (00000000 00000000 00000000
     *       8     4           (object header)                           05 00 00 f8 (00000101 00000000 00000000
     *      12     4           (object header)                           03 00 00 00 (00000011 00000000 00000000
     *      这里的3表示数组的长度
     *      16     3   boolean [Z.<elements>                             N/A
     *      19     5           (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 5 bytes external = 5 bytes total
     */
    static void array() {
        boolean[] booleans = new boolean[3];
        System.out.println(ClassLayout.parseInstance(booleans).toPrintable());
    }

    volatile static Object consumer;

    /**
     * 0     4        (object header)                           09 00 00 00 (00001001 00000000 00000000 00000000) (9)
     * 0     4        (object header)                           11 00 00 00 (00010001 00000000 00000000 00000000) (17)
     * 0     4        (object header)                           19 00 00 00 (00011001 00000000 00000000 00000000) (25)
     * 0     4        (object header)                           21 00 00 00 (00100001 00000000 00000000 00000000) (33)
     * 0     4        (object header)                           29 00 00 00 (00101001 00000000 00000000 00000000) (41)
     * 0     4        (object header)                           31 00 00 00 (00110001 00000000 00000000 00000000) (49)
     * 0     4        (object header)                           31 00 00 00 (00110001 00000000 00000000 00000000) (49)
     *
     */
    static void age() {
        Object instance = new Object();
        long lastAddr = VM.current().addressOf(instance);
        ClassLayout layout = ClassLayout.parseInstance(instance);

        for (int i = 0; i < 10_000; i++) {
            long currentAddr = VM.current().addressOf(instance);
            if (currentAddr != lastAddr) {
                System.out.println(layout.toPrintable());
            }

            for (int j = 0; j < 10_000; j++) {
                consumer = new Object();
            }

            lastAddr = currentAddr;
        }
    }
    /**
     * com.guyu.FieldArrangement object internals:
     *  OFFSET  SIZE      TYPE DESCRIPTION                               VALUE
     *       0    12           (object header)                           N/A
     *      12     4       int FieldArrangement.fourth                   N/A
     *      16     8    double FieldArrangement.third                    N/A
     *      24     2      char FieldArrangement.second                   N/A
     *      26     1   boolean FieldArrangement.first                    N/A
     *      27     1   boolean FieldArrangement.fifth                    N/A
     *      28     4           (loss due to the next object alignment)
     * Instance size: 32 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
    static void fieldArrangement() {
        System.out.println(ClassLayout.parseClass(FieldArrangement.class).toPrintable());
    }

    /**
     * com.guyu.SimpleInt object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0    12        (object header)                           N/A
     *      12     4    int SimpleInt.state                           N/A
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     */
    static void simpleIntLayoutClass() {
        System.out.println(ClassLayout.parseClass(SimpleInt.class).toPrintable());
    }

    /**
     * com.guyu.SimpleInt object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     *       8     4        (object header)                           43 c1 00 f8 (01000011 11000001 00000000 11111000) (-134168253)
     *      12     4    int SimpleInt.state                           0
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     * 242481580
     * com.guyu.SimpleInt object internals:
     *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     *       0     4        (object header)                           01 ac f9 73 (00000001 10101100 11111001 01110011) (1945742337)
     *       4     4        (object header)                           0e 00 00 00 (00001110 00000000 00000000 00000000) (14)
     *       8     4        (object header)                           43 c1 00 f8 (01000011 11000001 00000000 11111000) (-134168253)
     *      12     4    int SimpleInt.state                           0
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     * 其中, 0e 73 f9 ac十进制值就是242481580与上面输出的hashCode一致
     */
    static void simpleIntLayoutObject() {
        SimpleInt simpleInt = new SimpleInt();
        System.out.println(ClassLayout.parseInstance(simpleInt).toPrintable());
        System.out.println(simpleInt.hashCode());
        System.out.println(ClassLayout.parseInstance(simpleInt).toPrintable());
    }

    /**
     * # Running 64-bit HotSpot VM.
     * # Objects are 8 bytes aligned.
     * # Field sizes by type: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
     * # Array element sizes: 4, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
     * references, booleans, bytes, shorts, chars, ints, floats, longs, doubles
     *
     * 如果禁用"-XX:-UseCompressedOops"
     * 则输出为
     * # Field sizes by type: 8, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
     * # Array element sizes: 8, 1, 1, 2, 2, 4, 4, 8, 8 [bytes]
     * 引用类型占用8字节
     */
    static void vm_details() {
        System.out.println(VM.current().details());
    }
}
