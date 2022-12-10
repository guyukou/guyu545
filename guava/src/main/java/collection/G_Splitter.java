package collection;

import com.google.common.base.Splitter;

public class G_Splitter {
    public static void main(String[] args) {
        String s = "8,10,12";
         Splitter.on(",").splitToStream(s)
                 .forEach(System.out::println);

    }
}
