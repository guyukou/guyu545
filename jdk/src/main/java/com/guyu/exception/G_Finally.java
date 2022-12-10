package com.guyu.exception;

import java.util.concurrent.TimeUnit;

/**
 * @author guyu06
 * @date 2022/9/21 2:47 PM
 */
public class G_Finally {
    public static void main(String[] args) throws Exception{
        try {
            throw new Exception("exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            System.out.println("before exception");
        }

    }
}
