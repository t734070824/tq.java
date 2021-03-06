package _3_aop._9_spring_aop_process_one._ProxyFactory;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author 734070824@qq.com
 * @date 2018/10/11 19:45
 */
public class ProxyFactoryCglibApp {

    public static void main(String[] args) {
        /**
         * 要代理的接口
         */
        Executable task = new Executable();
        ProxyFactory weaver = new ProxyFactory(task);

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
        Executable proxyObject = (Executable) weaver.getProxy();
        proxyObject.execute();

        /**
         * class _3_aop._9_spring_aop_process_one._ProxyFactory.Executable$$EnhancerByCGLIB$$938f93b7
         */
        System.err.println(proxyObject.getClass());
    }
}
