package _book._java_performance._4_jvm_performance_monitoring;

import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/5/24 13:35
 */
public class GcLogAnalyze {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        test1();
    }

    /**
     *  //-XX:+PrintGCDetails -XX:+UseParallelGC -Xms300M -Xms300M
     */
    private static void test1() {
        while (true){
            byte[] allocation1,allocation2,allocation3;
            allocation1 = new byte[_1M / 4];
            allocation2 = new byte[3 * _1M];
            allocation3 = new byte[3 * _1M];
            allocation3 = null;

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
