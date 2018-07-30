package _aop_sound_code_analyze._springaop_vs_aspectj;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author 734070824@qq.com
 * @date 2018/7/30 11:38
 */
public class MyAspect implements MethodInterceptor{


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.err.println("1");
        Object obj = invocation.proceed();
        System.err.println("2");
        return obj;
    }
}
