package alibaba.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class G_TtlRunnable {
    private static ThreadLocal<String> tl = new InheritableThreadLocal<>();
    static {
        tl.set("guyu");
    }
    public static void main(String[] args) {
        System.out.println(tl.get());
        ExecutorService executorService = Executors.newCachedThreadPool();
        TtlRunnable ttlRunnable = TtlRunnable.get(() -> {
            System.out.println(tl.get());
        });
        executorService.execute(ttlRunnable);

    }
}
