package _overflow;

/**
 * MathAbs
 * @author 734070824@qq.com
 * @date 2018/6/1 16:21
 */
public class MathAbs {

    public static void main(String[] args) {
        System.err.println(Integer.MIN_VALUE);
        int abs = Math.abs(Integer.MIN_VALUE);

        System.err.println(abs);
        System.err.println(-Integer.MIN_VALUE);
        System.err.println(Integer.MAX_VALUE + 1);
    }
}
