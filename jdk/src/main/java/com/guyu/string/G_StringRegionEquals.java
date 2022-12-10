package com.guyu.string;

/**
 * @author guyu06
 * @date 2022/9/20 7:50 PM
 */
public class G_StringRegionEquals {
    public static void main(String[] args) {
        String urlPattern = "/demo/te.*";
        String uri = "/demo/test/";
        System.out.println(urlPattern.regionMatches(0, uri, 0, urlPattern.length() - 2));
    }
}
