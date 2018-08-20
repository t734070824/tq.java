package _arithmetic;

/**
 * 反转一个3位整数
 * @author 734070824@qq.com
 * @date 2018/4/20 17:31
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.err.println(Integer.MAX_VALUE);
        System.err.println(Integer.MIN_VALUE);
        ReverseInteger reverseInteger = new ReverseInteger();
        System.err.println(reverseInteger.reverseInteger2(900));
        System.err.println(reverseInteger.reverseInteger2(120));
        System.err.println(reverseInteger.reverse(1133333322));
    }

    /**
     * 772ms
     * 123 反转之后是 321。900 反转之后是 9。
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        int num = 0;
        int[] arr = new int[3];
        arr[0] = number / 100;
        arr[1] = number % 100 / 10;
        arr[2] = number % 10;

        for (int i = arr.length - 1; i >= 0; i--) {
            num += arr[i] * Math.pow(10, i);
        }
        return num;
    }


    public int reverseInteger2(int number) {
        // write your code here
        return number%10*100+number%100/10*10+number/100;
    }


    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
     * https://leetcode-cn.com/problems/reverse-integer/solution/
     * Int.max = 2147483647
     * Int.min = -2147483648
     * 为了便于解释，我们假设 rev 是正数。
     *      如果 temp = rev*10+pop 导致溢出，那么一定有 rev >= Int.Max/10
     *      如果 rev >= Int.Max/10,那么 temp=rev*10+pop一定溢出
     *      如果 rev == Int.Max/10, 只有pop>7, temp =rev*10+pop一定溢出
     * O(log(x))
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }




}
