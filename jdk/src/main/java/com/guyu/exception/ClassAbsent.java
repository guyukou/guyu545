package com.guyu.exception;


public class ClassAbsent {
    public static void main(String[] args) {
        noClassDef();
    }

    static void classNotFound() {
        try {
            Class.forName("gy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 编译后删除ClassAbsentX.class再运行就可以出现如下异常
     * xception in thread "main" java.lang.NoClassDefFoundError: com/guyu/exception/ClassAbsent$ClassAbsentX
     * 	at com.guyu.exception.ClassAbsent.noClassDef(ClassAbsent.java:18)
     * 	at com.guyu.exception.ClassAbsent.main(ClassAbsent.java:6)
     * Caused by: java.lang.ClassNotFoundException: com.guyu.exception.ClassAbsent$ClassAbsentX
     * 	at java.net.URLClassLoader.findClass(URLClassLoader.java:387)
     * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
     * 	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:352)
     * 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
     * 	... 2 more
     */
    static void noClassDef() {
        System.out.println(new ClassAbsentX());
    }

    static class ClassAbsentX {}
}
