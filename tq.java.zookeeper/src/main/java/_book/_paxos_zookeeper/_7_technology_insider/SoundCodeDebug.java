package _book._paxos_zookeeper._7_technology_insider;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 调试方式
 * https://zhuanlan.zhihu.com/p/45823132
 * @author 734070824@qq.com
 * @date 2019/4/19 10:57
 */
public class SoundCodeDebug implements Watcher {

    private  static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.7.194:2181", 5000, new SoundCodeDebug());
        System.err.println(zooKeeper.getState());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String path1 = zooKeeper.create("/zk-test-java",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.err.println("create: " +path1);

        TimeUnit.SECONDS.sleep(1000);

    }

    @Override
    public void process(WatchedEvent event) {
        System.err.println("Event:" + event);
        if(Watcher.Event.KeeperState.SyncConnected == event.getState()){
            countDownLatch.countDown();
        }

    }


}
