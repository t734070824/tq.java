package _shift;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 无符号移位
 * @author 734070824@qq.com
 * @date 2018/3/21 14:02
 */
public class UnsignedShift {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.err.println(MAXIMUM_CAPACITY);
        System.err.println(MAXIMUM_CAPACITY >>> 1);

        System.err.println("*************************");

        System.err.println(-1 >>> 1);


        System.err.println("*************************");
        new ReentrantLock().lock();


        System.err.println("*************************");
        new ReentrantLock().lock();
        System.out.println(23 >>> 33);
        System.out.println(23 >>> 1);


        System.err.println("*************************");

    }
}
