package _book._redis_development_and_operation._4_client;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

/**
 * pipeLine
 * @author 734070824@qq.com
 * @date 2018/5/2 20:11
 */
public class PipeLineApp {

    public static void main(String[] args) {

    }

    public void mdel(List<String> keys) {
        Jedis jedis = new Jedis("127.0.0.1");
        // 1)生成pipeline对象
        Pipeline pipeline = jedis.pipelined();
        // 2)pipeline执行命令， 注意此时命令并未真正执行
        for (String key : keys) {
            pipeline.del(key);
        }
        // 3)执行命令
        pipeline.sync();
    }
}
