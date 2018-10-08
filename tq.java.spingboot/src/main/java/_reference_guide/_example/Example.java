package _reference_guide._example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 734070824@qq.com
 * @date 2018/10/8 10:50
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @Value(value = "${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
    @Value("${book.pinyin}")
    private String bookPinYin;


    @RequestMapping("/")
    String home() {
        return "Hello World12355!";
    }

    @RequestMapping("/book")
    String book() {
        return bookAuthor + "--" + bookName + "--" + bookPinYin;
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}