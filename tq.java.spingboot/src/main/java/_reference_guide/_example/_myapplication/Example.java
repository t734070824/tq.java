package _reference_guide._example._myapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 734070824@qq.com
 * @date 2018/10/8 10:50
 */
@RestController
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World12355!";
    }


}