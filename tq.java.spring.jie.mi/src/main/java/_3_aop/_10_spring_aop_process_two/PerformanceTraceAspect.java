package _3_aop._10_spring_aop_process_two;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

/**
 * @Aspect
 * @author 734070824@qq.com
 * @date 2018/10/13 14:05
 */

@Aspect
public class PerformanceTraceAspect {

    private final Log logger = LogFactory.getLog(PerformanceTraceAspect.class);

    @Pointcut("execution(public void *.method1()) || execution(public void *.method2())")
    public void pointcutName(){}

    @Around("pointcutName()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable{
        StopWatch watch = new StopWatch();
        try{
            watch.start();
            return joinPoint.proceed();
        }finally {
            watch.stop();
            logger.info("method : " + joinPoint.getSignature().getName() + "--" + watch.toString());
        }
    }

}
