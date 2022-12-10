package com.guyu.exception;

import java.util.Random;

/**
 * @author guyu06
 * @date 2022/9/21 11:29 AM
 */
public class G_CatchExceptionWhenError {

    public static void main(String[] args) {
        testThrowError();
//        testThrowRuntime();
    }

    private static void testThrowError() {
        try {
            if (new Random() != null) {
                throw new MuteRequestError();
            }
        } catch (Exception e) {
            System.out.println("catch e when throw error" + e);
        }
    }

    private static void testThrowRuntime() {
        try {
            if (new Random() != null) {
                throw new MuteRequestException();
            }
        } catch (Exception e) {
            System.out.println("catch e when throw runtime" + e);
        }
    }

}

class MuteRequestError extends Error {

}

class MuteRequestException extends RuntimeException {

}
