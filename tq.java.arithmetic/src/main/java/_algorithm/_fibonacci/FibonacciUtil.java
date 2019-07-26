package _algorithm._fibonacci;

public class FibonacciUtil {

    static int  n1 = 0;//记录普通的递归次数
    static int n2 = 0;//优化的递归次数


    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一
     对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     1.程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
     * @param month
     */
    public static int a(int month){
        n1++;
        if(month == 1 || month == 2){
            return 1;
        } else {
            return a(month-1) + a(month-2);
        }
    }

    //优化 尾递归

    public static int a(int month, int a, int b){
        n2++;
        if(month > 2){
            return a(month-1, b, a+b);
        }
        return b;
    }

    public static void main(String[] args) {

        System.err.println(a(10));
        System.err.println(a(10, 1, 1));
        System.err.println(n1);
        System.err.println(n2);
    }

}
