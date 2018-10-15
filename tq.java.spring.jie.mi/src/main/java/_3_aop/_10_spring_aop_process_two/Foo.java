package _3_aop._10_spring_aop_process_two;

import org.springframework.stereotype.Component;

/**
 * @author 734070824@qq.com
 * @date 2018/10/13 14:13
 */
@Component(value = "target")
public class Foo {

    public void method1(){
        System.err.println("method1");
    }


    public void method2(){
        System.err.println("method2");
    }
}
