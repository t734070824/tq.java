package _common_divisor;

public class CommonDivisorUtil {

    /**
     * 欧几里得算法
     * 计算两个非负整数p和q的最大公约数：
     *  若q=0,则最大公约数为p,否则,将p除以q得到余数r,p和q的最大公约数就是q和r的最大公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q){
        if(p < 0 || q < 0)
            throw new RuntimeException("para < 0");
        if(q == 0) return p;
        int r = p % q;
        return gcd(q, r);

    }

}
