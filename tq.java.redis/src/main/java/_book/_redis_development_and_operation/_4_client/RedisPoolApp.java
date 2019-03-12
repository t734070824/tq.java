package _book._redis_development_and_operation._4_client;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 连接池
 *
 * @author 734070824@qq.com
 * @date 2018/5/2 20:00
 */
public class RedisPoolApp {

    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, "192.168.101.184", 6379);

        Jedis jedis = null;
        try {
            // 1. 从连接池获取jedis对象
            jedis = jedisPool.getResource();
            // 2. 执行操作
            jedis.get("hello");
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        } finally {
            if (jedis != null) {
                // 如果使用JedisPool， close操作不是关闭连接， 代表归还连接池
                jedis.close();
            }
        }
    }
}
