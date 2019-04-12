package _book._paxos_zookeeper._5_use_zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2019/4/12 17:17
 */
public class Zookeeper_With_SID_PASSWD implements Watcher {

    private  static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper(
                "192.168.7.215:2181",
                5000,
                new Zookeeper_With_SID_PASSWD());
        System.err.println(zooKeeper.getState());



        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long sessionId = zooKeeper.getSessionId();
        byte[] sessionPasswd = zooKeeper.getSessionPasswd();


        //使用非法的 sid, spasswd
        zooKeeper = new ZooKeeper(
                "192.168.7.215:2181",
                5000,
                new Zookeeper_With_SID_PASSWD(),
                1L,
                "test".getBytes());

        System.err.println("ill");

        //使用正确de
        zooKeeper = new ZooKeeper(
                "192.168.7.215:2181",
                5000,
                new Zookeeper_With_SID_PASSWD(),
                sessionId,
                sessionPasswd);

        System.err.println("ssss");
        TimeUnit.SECONDS.sleep(1000);




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
