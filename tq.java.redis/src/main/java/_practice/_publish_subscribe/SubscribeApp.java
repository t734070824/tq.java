package _practice._publish_subscribe;

import redis.clients.jedis.Jedis;

/**
 * @author 734070824@qq.com
 * @date 2018/6/26 16:08
 */
public class SubscribeApp {

    public static void main(String[] args) {

        Jedis redis = new Jedis("192.168.101.39", 6379, 400000);

        redis.subscribe(new RedisMsgSubListener(), "123");
    }
}
