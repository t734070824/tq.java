package _book._paxos_zookeeper._5_use_zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2019/4/12 17:17
 */
public class Zookeeper_Create_ASync implements Watcher {

    private  static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.7.215:2181",
                5000, new Zookeeper_Create_ASync());
        System.err.println(zooKeeper.getState());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        zooKeeper.create("/zk-test-java",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL, new IStringCallback(), "123");

        zooKeeper.create("/zk-test-java",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL,new IStringCallback(), "456");

        System.err.println("start");


        TimeUnit.SECONDS.sleep(100);
    }

    @Override
    public void process(WatchedEvent event) {
        System.err.println("Event:" + event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            countDownLatch.countDown();
        }

    }

    static class IStringCallback implements AsyncCallback.StringCallback{

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.err.println("result: " + rc + "---" + path + "---" + path  + "---" + ctx  + "---" + name);
        }
    }

}


