package _common_divisor;

/**
 * 公约数
 */
public class CommonDivisorUtil {

    //TODO 欧几里得算法 -- 除法 理解并证明

    /**
     * 欧几里得算法 -- 除法
     * 描述: 两个整数的最大公约数等于其中较小的数和两数的差的最大公约数
     * 计算两个非负整数p和q的最大公约数：
     *  若q=0,则最大公约数为p,否则,将p除以q得到余数r,p和q的最大公约数就是q和r的最大公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd1(int p, int q){
        if(p < 0 || q < 0)
            throw new RuntimeException("para < 0");
        if(q == 0) return p;
        int r = p % q;
        return gcd1(q, r);
    }

    /**
     * 欧几里得算法 -- 减法
     * 描述: 两个整数的最大公约数等于其中较小的数和两数的差的最大公约数
     * 例如，252和105的最大公约数是21（252 = 21 × 12；105 = 21 × 5）；
     * 因为252 − 105 = 147，所以147和105的最大公约数也是21。在这个过程中，较大的数缩小了，
     * 所以继续进行同样的计算可以不断缩小这两个数直至其中一个变成零。
     * 这时，所剩下的还没有变成零的数就是两数的最大公约数。
     * 计算两个非负整数p和q的最大公约数：
     * @param p
     * @param q
     * @return
     */
    public static int gcd2(int p, int q){
        if(p < 0 || q < 0)
            throw new RuntimeException("para < 0");
        if(q == 0) return p;
        int min = (q > p) ? p : q;
        int diff = (q == min) ? (p - q) : (q - p);
        if(min == 0) return diff;
        if(diff == 0) return min;
        return  gcd2(min, diff);
    }

    public static void main(String[] args) {
        System.err.println(gcd2(252, 105));
        System.err.println(gcd2(10215, 123123));
        System.err.println(gcd2(4353, 456));

        System.err.println(gcd1(252, 105));
        System.err.println(gcd1(10215, 123123));
        System.err.println(gcd1(4353, 456));
    }
}
