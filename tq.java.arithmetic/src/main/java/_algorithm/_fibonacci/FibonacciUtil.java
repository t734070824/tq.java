package _algorithm._fibonacci;

public class FibonacciUtil {

    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一
     对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
     * @param month
     */
    public static int a(int month){
        if(month == 1 || month == 2){
            return 1;
        } else {
            return a(month-1) + a(month-2);
        }

    }
}
