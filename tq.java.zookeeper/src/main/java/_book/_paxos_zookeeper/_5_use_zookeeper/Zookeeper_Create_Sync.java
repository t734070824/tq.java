package _book._paxos_zookeeper._5_use_zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 734070824@qq.com
 * @date 2019/4/12 17:17
 */
public class Zookeeper_Create_Sync implements Watcher {

    private  static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.7.215:2181", 5000, new Zookeeper_Create_Sync());
        System.err.println(zooKeeper.getState());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String path1 = zooKeeper.create("/zk-test-java",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);
        System.err.println("create: " +path1);

        String path2 = zooKeeper.create("/zk-test-java",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.err.println("create: " +path2);

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
