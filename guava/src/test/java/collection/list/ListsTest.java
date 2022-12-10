package collection.list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author guyu06
 * @date 2022/11/20 22:10
 */
public class ListsTest {

    @Test
    public void testNewListFromAbnormalList() {
        List<String> strings = Arrays.asList("hello", null, "world");
        assertEquals(newArrayList(strings), Arrays.asList("hello", null, "world"));
    }
}
