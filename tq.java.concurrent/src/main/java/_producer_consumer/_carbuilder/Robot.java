package _producer_consumer._carbuilder;

import java.util.concurrent.BrokenBarrierException;

/**
 * 机器人
 * @author 734070824@qq.com
 * @date 2018/3/10 10:35
 */
public abstract class Robot implements Runnable {

    private RobotPool pool;

    public Robot(RobotPool pool) {
        this.pool = pool;
    }

    protected Assembler assembler;

    public Robot assignAssembler(Assembler assembler){
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;

    public synchronized void engage(){
        engage = true;
        notifyAll();
    }

    @Override
    public void run() {
        try {
            powerDown(); // Wait until needed
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await(); // Synchronize
                // We're done with that job...
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null;
        // Put ourselves back in the available pool:
        pool.release(this);
        while (engage == false)
            wait();
    }

    //执行任务
    public abstract void performService();
}
