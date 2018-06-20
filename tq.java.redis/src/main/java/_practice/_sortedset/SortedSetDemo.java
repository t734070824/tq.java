package _practice._sortedset;

import redis.clients.jedis.Jedis;

/**
 * @author 734070824@qq.com
 * @date 2018/6/20 19:32
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        Jedis redis = new Jedis("192.168.101.39", 6379, 400000);
        redis.select(0);


        //返回成员 与 分数
//        redis.zrangeWithScores()
    }
}
