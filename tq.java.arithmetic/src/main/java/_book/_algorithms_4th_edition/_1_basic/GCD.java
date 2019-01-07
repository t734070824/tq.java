package _book._algorithms_4th_edition._1_basic;

/**
 * 最大公约数-- 欧几里得算法
 * @author 734070824@qq.com
 * @date 2018/9/12 11:30
 */
public class GCD {

    public  static  int gcd(int p, int q){
        if(q == 0){
            return p;
        }
        int  r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.err.println(gcd(8, 21));
    }
}
