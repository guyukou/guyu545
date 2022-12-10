package com.guyu.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guyu06
 * @date 2022/8/3 6:52 下午
 */
public class G_List {
    public static void main(String[] args) {
        removeNullList();
    }

    /**
     * removeAll不能接收null,会有NPE
     */
    static void removeNullList() {
        List<Integer> originList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> toRemoveList = null;
        originList.removeAll(toRemoveList);
        System.out.println(originList);
    }
}
