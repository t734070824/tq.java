package _producer_consumer._bank;

import java.util.concurrent.TimeUnit;

/**
 * 出纳员
 * @author 734070824@qq.com
 * @date 2018/3/10 11:03
 */
public class Teller implements Runnable, Comparable<Teller>{

    private static int counter = 0;

    private final int id = counter ++;

    private int consumersServer = 0;

    private ConsumerLine line;

    private boolean servingCustimerLine = true;

    public Teller(ConsumerLine line) {
        this.line = line;
    }

    @Override
    public synchronized int compareTo(Teller o) {
        return consumersServer < o.consumersServer ? -1:(consumersServer == o.consumersServer ? 0 : 1);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Consumer consumer = line.take();
                TimeUnit.MILLISECONDS.sleep(consumer.getServiceTime());
                synchronized (this) {
                    consumersServer++;
                    while (!servingCustimerLine) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted");
        }
        System.err.println("terminating");
    }


    public synchronized void doSomeThingElse(){
        consumersServer = 0;
        servingCustimerLine = false;
    }


    public synchronized void serveCustomerLine(){
        assert !servingCustimerLine:"already serving:" + this;
        servingCustimerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {return "Teller " + id +  " ";}
    public String shortString(){return "T " + id +  " ";}

}
