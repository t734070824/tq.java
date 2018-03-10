package _producer_consumer._bank;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 柜员管理
 * @author 734070824@qq.com
 * @date 2018/3/10 11:05
 */
public class TellerManager implements Runnable{

    private ExecutorService exec;

    private ConsumerLine line;

    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();

    private Queue<Teller> tellerDoingOtherThing = new LinkedBlockingQueue<>();

    //调整周期
    private int adjustmentPeriod;

    private static Random random = new Random(47);

    public TellerManager(ExecutorService exec, ConsumerLine line, int adjustmentPeriod) {
        this.exec = exec;
        this.line = line;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(line);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber(){
        if(line.size() / workingTellers.size() > 2){
            if(tellerDoingOtherThing.size() > 0){
                Teller teller = tellerDoingOtherThing.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(line);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }

        if(workingTellers.size() > 1 && line.size() / workingTellers.size() < 2){
            reassignOneTeller();
        }
    }

    public void reassignOneTeller() {
        Teller teller = workingTellers.poll();
        teller.doSomeThingElse();
        tellerDoingOtherThing.offer(teller);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.err.print(line + "{");
                for(Teller teller : workingTellers){
                    System.err.print(teller.shortString());
                }
                System.err.println("}");
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
        System.err.println("terminating");
    }


    @Override
    public String toString() {
        return "TellerManger ";
    }
}
