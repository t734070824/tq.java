package _book._paxos_zookeeper._5_use_zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 734070824@qq.com
 * @date 2019/4/12 17:17
 */
public class Zookeeper_Simple implements Watcher {

    private  static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.7.215:2181", 5000, new Zookeeper_Simple());
        System.err.println(zooKeeper.getState());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("start");
    }

    @Override
    public void process(WatchedEvent event) {
        System.err.println("Event:" + event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            countDownLatch.countDown();
        }

    }
}
