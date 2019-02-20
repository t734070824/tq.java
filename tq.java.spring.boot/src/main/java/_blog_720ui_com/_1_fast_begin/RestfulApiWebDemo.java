package _blog_720ui_com._1_fast_begin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 734070824@qq.com
 * @date 2019/2/20 15:27
 */
@RestController
@EnableAutoConfiguration
public class RestfulApiWebDemo {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestfulApiWebDemo.class, args);
    }
}