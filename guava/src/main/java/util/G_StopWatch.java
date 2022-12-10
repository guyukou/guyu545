package util;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.LazyBoy;

import java.util.concurrent.TimeUnit;

/**
 * @author guyu06
 * @date 2022/9/19 4:36 PM
 */
public class G_StopWatch {
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        LazyBoy.sleepS(1);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.reset();
        LazyBoy.sleepS(2);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        LazyBoy.sleepS(3);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
