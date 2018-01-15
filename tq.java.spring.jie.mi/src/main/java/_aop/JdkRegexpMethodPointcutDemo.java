package _aop;

import org.springframework.aop.support.JdkRegexpMethodPointcut;

import java.lang.reflect.Method;

public class JdkRegexpMethodPointcutDemo {

    public static void main(String[] args) throws NoSuchMethodException {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();

        pointcut.setPattern(".*match.*");
        Method method = MatchMethod.class.getMethod("match");
        boolean matches = pointcut.matches(method, MatchMethod.class);
        System.err.println(matches);

    }


}
