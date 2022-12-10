package com.guyu.classloader;

import java.util.ArrayList;


/**
 * @author guyu03
 * Created on 2021-07-08
 */
public class G_ClassLoader {
    public static void main(String[] args) throws Exception {
        printClassLoaders();
    }

    public static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + G_ClassLoader.class.getClassLoader());

//        System.out.println("Classloader of Logging:"
//                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
