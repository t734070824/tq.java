package _redis_development_and_operation._4_client;

import redis.clients.jedis.Jedis;

/**
 * 获取客户端
 * @author 734070824@qq.com
 * @date 2018/5/2 19:56
 */
public class GetRedisApp {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.101.184", 6379);
        String result = jedis.set("tq","11");
        System.err.println(result);
    }
}
