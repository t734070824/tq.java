package _3_aop._9_spring_aop_process_one._ProxyFactory;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author 734070824@qq.com
 * @date 2018/10/11 19:45
 */
public class ProxyFactoryDyApp {

    public static void main(String[] args) {
        /**
         * 要代理的接口
         */
        MockTask task = new MockTask();
        ProxyFactory weaver = new ProxyFactory(task);
//        weaver.setInterfaces(new Class[]{ITask.class});


        /**
         * joinpoint advice
         */
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());


        /**
         * Aspect, weaver
         */
        weaver.addAdvisor(advisor);
        ITask proxyObject = (ITask) weaver.getProxy();
        proxyObject.execute();

        /**
         * class com.sun.proxy.$Proxy0
         */
        System.err.println(proxyObject.getClass());
    }
}
