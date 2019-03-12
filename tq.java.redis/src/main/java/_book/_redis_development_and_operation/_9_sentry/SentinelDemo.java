package _book._redis_development_and_operation._9_sentry;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 734070824@qq.com
 * @date 2018/6/30 14:46
 */
public class SentinelDemo {

    public static void main(String[] args) {
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.101.39:26379");
        sentinels.add("192.168.101.39:26380");
        sentinels.add("192.168.101.39:26381");
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = null;
        try {
            jedis = jedisSentinelPool.getResource();
            String key = jedis.get("key");
            System.err.println(key);
            // jedis command
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null)
                jedis.close();
        }
    }
}
