package _book._1_introduction._recursion;

/**
 * @author 734070824@qq.com
 * @date 2018/8/3 14:04
 */
public class Fibonacci {


    /**
     * fib(n) =
     *          n       n<=1
     *          fib(n-1) + fib(n-2) n>=2
     *
     * 时间: O(n^2)-->重复计算
     * @param n
     * @return
     */
    int fibonacci_erfen(int n){
        return n <2 ? n : (fibonacci_erfen(n-1) + fibonacci_erfen(n-2));
    }


    /**
     *  迭代
     *  获取第 N 项
     * @param n
     * @return
     */
    int fibI(int n){
        //fib(0)=0, fib(1) =1
        int f= 0, g = 1;
        while (n-- > 0){
            //now
            g = g+f;
            //prev
            f = g - f;
        }
        return f;
    }


    public static void main(String[] args) {
        Fibonacci c = new Fibonacci();
        System.err.println(c.fibonacci_erfen(10));
    }
}
