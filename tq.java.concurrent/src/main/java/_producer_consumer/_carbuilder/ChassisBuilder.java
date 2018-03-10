package _producer_consumer._carbuilder;

import java.util.concurrent.TimeUnit;

/**
 * 汽车底盘
 * @author 734070824@qq.com
 * @date 2018/3/10 10:33
 */
public class ChassisBuilder implements Runnable{
    private CarQueue carQueue;

    private int counter = 0;

    public ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                carQueue.add(c);
            }
        } catch (InterruptedException e) {
            System.err.println("CarBuilder Interrupted");
        }

        System.err.println("CarBuilder off");
    }
}
