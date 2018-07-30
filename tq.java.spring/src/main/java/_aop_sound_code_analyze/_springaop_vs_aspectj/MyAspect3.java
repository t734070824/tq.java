package _aop_sound_code_analyze._springaop_vs_aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 734070824@qq.com
 * @date 2018/7/30 11:38
 * Aspectj没有提供接口
 */
@Component
@Aspect
public class MyAspect3 {

    @Pointcut("execution(* _aop_sound_code_analyze._springaop_vs_aspectj.*.*(..))")
    private void pointCut(){}

    private void pointCut1(){}


    public void myBefore(JoinPoint joinPoint){
        System.err.println("前置通知: " + joinPoint.getSignature().getName());
    }


    public void myAfterReturning(JoinPoint joinPoint, Object ret){
        System.err.println("后置通知: " + ret);
    }

    @Around("pointCut()")
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
