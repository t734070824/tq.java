package _3_aop._10_spring_aop_process_two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 734070824@qq.com
 * @date 2018/10/13 14:35
 */
public class AnnotationAwareAspectJAutoProxyCreatorApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("_2/aspect.xml");
        Foo target = (Foo) context.getBean("target");
        target.method1();
        target.method2();

    }

}
