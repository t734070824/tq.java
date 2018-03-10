package _threadpoolexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Shutdown 是否阻塞 --> 不阻塞
 * @author 734070824@qq.com
 * @date 2018/3/10 10:21
 */
public class ShutdownBlock {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(10);
                        System.err.println("10");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        service.shutdown();

        System.err.println("shutdown");

    }
}
