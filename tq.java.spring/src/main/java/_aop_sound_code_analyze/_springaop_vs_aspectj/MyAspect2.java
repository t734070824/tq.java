package _aop_sound_code_analyze._springaop_vs_aspectj;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 734070824@qq.com
 * @date 2018/7/30 11:38
 * Aspectj没有提供接口
 */
public class MyAspect2 {


    public void myBefore(JoinPoint joinPoint){
        System.err.println("前置通知: " + joinPoint.getSignature().getName());
    }


    public void myAfterReturning(JoinPoint joinPoint, Object ret){
        System.err.println("后置通知: " + ret);
    }

    public Object myAround(ProceedingJoinPoint joinPoint)throws Throwable{
        System.err.println("1");
        Object obj = joinPoint.proceed();
        System.err.println("2");
        return obj;
    }


    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.err.println("抛出异常: " + e.getMessage());
    }

    public void myAfter(JoinPoint joinPoint){
        System.err.println("最终: ");
    }

}
