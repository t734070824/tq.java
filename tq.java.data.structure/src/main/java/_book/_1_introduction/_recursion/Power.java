package _book._1_introduction._recursion;

/**
 * @author 734070824@qq.com
 * @date 2018/8/3 10:50
 */
public class Power {

    /**
     * 幂函数 2^n (优化递归版)
     *
     *
     * 奇偶 --> 比特位
     * @param n
     * @return
     */
    long power2(int n){
        if(n == 0) {
            return 1;
        }
        return( n & 1) == 1 ? sqr(power2(n >> 1)) << 1 : sqr(power2(n >> 1));

    }

    long sqr(long a){
        return a * a;
    }
}
