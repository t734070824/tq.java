package _redis;

import _ityouknow._redis.RedisApplication;
import _ityouknow._redis.RedisConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;
/**
 * @author 734070824@qq.com
 * @date 2019/5/20 15:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aaa", "11");
        Assert.assertEquals("11", stringRedisTemplate.opsForValue().get("aaa"));
    }

}
