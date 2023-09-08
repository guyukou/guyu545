package collection.list;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author guyu06
 * @date 2023/4/11 10:13
 */
public class SetsTest {
    @Test
    public void test_SetsStaticMethods() {
        Set<Long> set = null;
        Assertions.assertThrows(NullPointerException.class, () -> Sets.newHashSet(set));
    }
}
