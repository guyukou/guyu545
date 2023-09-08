package com.guyu.util;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ParamsCheckUtils {

    public static boolean validIdLong(Long id) {
        return id != null && id > 0;
    }

    public static boolean validIdInt(Integer id) {
        return id != null && id > 0;
    }

    public static boolean validString(String s) {
        return StringUtils.isNotBlank(s);
    }

    public static boolean meaningLessStr(String s) {

        return Strings.isNullOrEmpty(s) || Objects.equals("0", s);
    }

    public static boolean meaningLessObj(Object obj) {

        return obj == null || meaningLessStr(String.valueOf(obj));
    }
}
