package com.guyu.string;

import java.util.StringTokenizer;

/**
 * @author guyu06
 * @date 2022/9/11 9:43 上午
 */
public class G_StringTokenizer {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("abc,def;ghj;123", ",;");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
        // 输出：
        // abc
        // def
        // ghj
        // 123
    }
}
