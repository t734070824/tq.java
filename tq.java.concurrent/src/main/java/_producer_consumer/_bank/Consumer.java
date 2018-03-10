package _producer_consumer._bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 消费者
 * @author 734070824@qq.com
 * @date 2018/3/10 11:00
 */
public class Consumer {

    public static final int MAX_LINE_SIZE = 50;

    public static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        ConsumerLine line = new ConsumerLine(MAX_LINE_SIZE);
        service.execute(new ConsumerGenerator(line));
        service.execute(new TellerManager(service, line, ADJUSTMENT_PERIOD));

    }


    private final int serviceTime;

    public Consumer(int serviceTime) {
        this.serviceTime = serviceTime;
    }


    public int getServiceTime(){
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}
