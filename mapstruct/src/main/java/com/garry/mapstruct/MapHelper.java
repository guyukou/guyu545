package com.garry.mapstruct;

/**
 * @author guyu06
 * @date 2022/11/19 11:46
 */
public class MapHelper {
    public int toInt(boolean b) {
        return b ? 1 : 0;
    }
    public boolean toBoolean(int i) {
        return i != 0;
    }
}
