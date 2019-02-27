package _leetcode._easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author 734070824@qq.com
 * @date 2019/2/27 14:52
 */
public class Reverse_integer {
    public int reverse(int x) {

        int sum=0;
        int x1=Math.abs(x);
        while(x1!=0){
            int a = sum;
            sum = a * 10 + x1 % 10;
            /**
             * 考虑溢出，则需要判断会在哪个阶段溢出；
             */
            if (sum / 10 != a) {
                return 0;
            }
            x1=x1/10;
        }
        if(x<0){
            sum=sum*(-1);
        }
        return sum;
    }


}
