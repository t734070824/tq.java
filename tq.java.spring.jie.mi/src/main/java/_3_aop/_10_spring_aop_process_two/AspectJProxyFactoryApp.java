package _3_aop._10_spring_aop_process_two;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author 734070824@qq.com
 * @date 2018/10/13 14:14
 */
public class AspectJProxyFactoryApp {

    public static void main(String[] args) {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);
        Foo proxy = weaver.getProxy();
        proxy.method1();
        proxy.method2();

    }
}
