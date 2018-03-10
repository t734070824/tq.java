package _producer_consumer._carbuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * 机器人工厂
 * @author 734070824@qq.com
 * @date 2018/3/10 10:34
 */
public class RobotPool {
    private Set<Robot> pool = new HashSet<>();
    public synchronized void add(Robot r){
        pool.add(r);
        notifyAll();
    }

    /**
     * 雇佣
     * @param robotType
     * @param d
     */
    public synchronized void hire(Class<? extends Robot> robotType, Assembler d) throws InterruptedException {
        for(Robot r : pool){
            if(r.getClass().equals(robotType)){
                pool.remove(r);
                r.assignAssembler(d);
                r.engage();
                return;
            }
            wait();
            hire(robotType, d);
        }
    }

    public synchronized void release(Robot r) {
        add(r);
    }
}
