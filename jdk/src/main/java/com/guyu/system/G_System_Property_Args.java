package com.guyu.system;

import java.util.Set;

public class G_System_Property_Args {
    public static void main(String[] args) {
        testProperties();
    }

    /**
     * <p>命令:java -DsomeProperty=someValue com.guyu.system.G_System_Property_Args
     * <p>输出true
     * <p>命令:java com.guyu.system.G_System_Property_Args -DsomeProperty=someValue
     * <p>输出false
     */
    private static void testProperties() {
        Set<String> allProperties = System.getProperties().stringPropertyNames();

        System.out.println(allProperties.contains("someProperty"));
    }


}
