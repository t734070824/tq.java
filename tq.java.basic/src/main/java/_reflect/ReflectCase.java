package _reflect;

import java.lang.reflect.Method;

/**
 * @author 734070824@qq.com
 * @date 2019/3/27 10:17
 */
public class ReflectCase {

    public static void main(String[] args) throws Exception {
        Proxy target = new Proxy();
        Method method = Proxy.class.getDeclaredMethod("run");
        method.invoke(target);
    }

    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }
}
