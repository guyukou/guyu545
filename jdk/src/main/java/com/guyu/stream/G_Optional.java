package com.guyu.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author guyu06
 * @date 2022/9/15 2:14 下午
 */
public class G_Optional {
    public static void main(String[] args) {
        nullMap(null);
        Map<String, String> m = new HashMap<>();
        m.put("abc", "def");
        nullMap(m);
    }

    /**
     * <pre>
     * Optional.ofNullable(map).map(m -> m.get("abc"))这样的代码，入参map如果为null，则后面的.map不会执行，相当于
     * Optional.of(map).filter(Objects::nonNull).map(m -> m.get("abc"))
     * </pre>
     * @param map
     */
    static void nullMap(Map<String, String> map) {

        System.out.println(Optional.ofNullable(map).map(m -> m.get("abc")).orElse("empty"));
    }
}
