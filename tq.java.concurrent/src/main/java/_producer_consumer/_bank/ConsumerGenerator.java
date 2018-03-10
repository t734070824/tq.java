package _producer_consumer._bank;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/3/10 11:01
 */
public class ConsumerGenerator implements Runnable{

    private ConsumerLine line;

    private static Random random = new Random(47);

    public ConsumerGenerator(ConsumerLine line) {
        this.line = line;
    }

    @Override
    public void run() {
        try {

            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                line.add(new Consumer(random.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.err.println("interrupted");
        }

        System.err.println("terminating");

    }
}
