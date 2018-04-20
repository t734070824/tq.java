package _arithmetic;

/**
 * 反转一个3位整数
 * @author 734070824@qq.com
 * @date 2018/4/20 17:31
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.err.println(reverseInteger.reverseInteger2(900));
        System.err.println(reverseInteger.reverseInteger2(120));
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
}
