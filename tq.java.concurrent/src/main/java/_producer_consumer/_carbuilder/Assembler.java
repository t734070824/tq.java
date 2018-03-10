package _producer_consumer._carbuilder;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 装配厂
 * @author 734070824@qq.com
 * @date 2018/3/10 10:35
 */
public class Assembler implements Runnable{

    private CarQueue chassisQueue, finishQueue;

    private Car car;

    private CyclicBarrier barrier = new CyclicBarrier(4);

    private RobotPool robotPool;



    public Assembler(CarQueue chassisQueue, CarQueue finishQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishQueue = finishQueue;
        this.robotPool = robotPool;
    }

    public Car car(){return car;}

    public CyclicBarrier barrier(){return barrier;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await(); // Until the robots finish
                // Put car into finishingQueue for further work
                finishQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            // This one we want to know about
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }

}