package _3_aop._9_10_spring_aop_process._ProxyFactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 734070824@qq.com
 * @date 2018/10/11 19:42
 */
public class PerformanceMethodInterceptor implements MethodInterceptor{
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long ts = System.currentTimeMillis();
        try {
            return invocation.proceed();
        }finally {
            System.err.println("used: " + (System.currentTimeMillis() - ts));
        }

    }
}
