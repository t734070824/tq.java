package _book._paxos_zookeeper._5_use_zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2019/4/12 17:17
 */
public class Zookeeper_Create_Auth {

    private  static String path = "/zk-book-auth_test";
    private  static String path2 = "/zk-book-auth_test/child";

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("192.168.7.215:2181",
                5000, null);
        System.err.println(zooKeeper.getState());

        zooKeeper.addAuthInfo("digest", "foo:true".getBytes());
        zooKeeper.create(path, "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
        zooKeeper.create(path2, "init".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);

        try{
            ZooKeeper zooKeeper2 = new ZooKeeper("192.168.7.215:2181",
                    5000, null);
            zooKeeper2.delete(path2, -1);
        }catch (Exception e){
            System.err.println("删除失败: " + e.getMessage());
        }

        ZooKeeper zooKeeper3 = new ZooKeeper("192.168.7.215:2181",
                5000, null);
        zooKeeper3.addAuthInfo("digest", "foo:true".getBytes());
        zooKeeper3.delete(path2, -1);
        System.err.println("success delete:" + path2);


        ZooKeeper zooKeeper4 = new ZooKeeper("192.168.7.215:2181",
                5000, null);
        //get
        System.err.println(new String(zooKeeper4.getData(path, false, null)));


        zooKeeper3.delete(path, -1);
        System.err.println("success delete:" + path);






    }


}


