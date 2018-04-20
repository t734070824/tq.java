package _threadpoolexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池 源码分析
 * @author 734070824@qq.com
 * @date 2018/4/20 15:40
 */
public class SourceAnalysis {

    public static void main(String[] args) {
        SourceAnalysis.main1();


    }

    /**
     *
     */
    public static void main1(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        executor.execute(new SleepThread());

        executor.execute(new SleepThread());

    }

    static class SleepThread implements Runnable{

        @Override
        public void run() {
            try {
                System.err.println("start sleep 100");
                TimeUnit.SECONDS.sleep(10);
                System.err.println("end sleep 100");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
