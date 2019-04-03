package _blog_720ui_com._1_fast_begin;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 734070824@qq.com
 * @date 2019/2/20 15:27
 */
@RestController
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class RestfulApiWebDemo {
//    @RequestMapping(value = {"/{project}/api/{rest}", "/{project}/api/{app}/{rest}"}, method = RequestMethod.GET)
//    String home(HttpServletRequest request) {
//        System.err.println("haha-->" + request.getRequestURL());
//        System.err.println("haha-->" + request.getRequestURI());
//        System.err.println("haha-->" + request.getContextPath());
//        System.err.println("haha-->" + request.getServletPath());
//        System.err.println("haha-->" + request.getQueryString());
//        return "Hello World!";
//    }
//
//    @RequestMapping(value = {"/{project}/api/{rest}", "/{project}/api/{app}/{rest}"}, method = RequestMethod.POST)
//    String home2(HttpServletRequest request, @RequestBody Object body) {
//        System.err.println("haha-->" +request.getRequestURL());
//        System.err.println("haha-->" +request.getRequestURI());
//        System.err.println("haha-->" +request.getContextPath());
//        System.err.println("haha-->" +request.getServletPath());
//        System.err.println("haha-->" +request.getQueryString());
//        System.err.println("haha-->" + body);
//        return "Hello World!";
//    }
//
//    @RequestMapping(value = {"asda/api/sd", "/asda/api/ios/asd"}, method = RequestMethod.POST)
//    String home3(HttpServletRequest request, @RequestBody Object body) {
//        System.err.println("home3 haha-->" +request.getRequestURL());
//        System.err.println("home3 haha-->" +request.getRequestURI());
//        System.err.println("home3 haha-->" +request.getContextPath());
//        System.err.println("home3 haha-->" +request.getServletPath());
//        System.err.println("home3 haha-->" +request.getQueryString());
//        System.err.println("home3 haha-->" + body);
//        return "Hello World!";
//    }

    @RequestMapping(value = {"/**"}, method = RequestMethod.GET)
    String home4(HttpServletRequest request) {
        System.err.println("home4-->" + request.getRequestURL());
        System.err.println("home4-->" + request.getRequestURI());
        System.err.println("home4-->" + request.getContextPath());
        System.err.println("home4-->" + request.getServletPath());
        System.err.println("home4-->" + request.getQueryString());
        return "Hello World!";
    }

    @RequestMapping(value = {"/**"}, method = RequestMethod.POST)
    String home5(HttpServletRequest request) {
        System.err.println("home5-->" + request.getRequestURL());
        System.err.println("home5-->" + request.getRequestURI());
        System.err.println("home5-->" + request.getContextPath());
        System.err.println("home5-->" + request.getServletPath());
        System.err.println("home5-->" + request.getQueryString());
        return "Hello World!";
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestfulApiWebDemo.class, args);
    }
}