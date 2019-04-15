package _book._paxos_zookeeper._5_use_zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2019/4/12 17:17
 */
public class Zookeeper_GetChildren implements Watcher {

    private  static CountDownLatch countDownLatch = new CountDownLatch(1);

    private static ZooKeeper zk = null;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        zk = new ZooKeeper("192.168.7.215:2181",
                5000, new Zookeeper_GetChildren());
        System.err.println(zk.getState());

        countDownLatch.await();
        String path = "/zk-book";
//        zk.create(path,
//                "".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE,
//                CreateMode.PERSISTENT);

        zk.create(path + "/c1",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);


        List<String> children = zk.getChildren(path, true);
        System.err.println("children: " + children);


        zk.create(path + "/c2",
                "".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL);

        System.err.println("start");


        TimeUnit.SECONDS.sleep(100);
    }

    @Override
    public void process(WatchedEvent event) {
        System.err.println("Event:" + event);
        if(Event.EventType.None == event.getType() && null == event.getPath()){
            countDownLatch.countDown();
        }else if(event.getType() == Event.EventType.NodeChildrenChanged){
            try {
                System.err.println("ReGet Child: " + zk.getChildren(event.getPath(), true));
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    static class IStringCallback implements AsyncCallback.StringCallback{

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.err.println("result: " + rc + "---" + path  + "---" + ctx  + "---" + name);
        }
    }

}


