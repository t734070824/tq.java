package _mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

/**
 * @author 734070824@qq.com
 * @date 2019/5/20 14:04
 */
@SpringBootApplication(exclude= RedisAutoConfiguration.class)
public class MysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
    }
}
