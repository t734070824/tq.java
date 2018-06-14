package _book._algorithms_4th_edition._1_basis;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 734070824@qq.com
 * @date 2018/6/1 16:30
 */
public class Practice {

    public static void main(String[] args) {
        //7
        System.err.println((0 + 15)/2);
        //false
        System.err.println(true && false || true && false);
        //1.618
        System.err.println((1+2.236)/2);
        //10.0
        System.err.println(1+2+3+4.0);
        //true
        System.err.println(4.1 >= 4);
        //33
        System.err.println(1+2+"3");

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }


    /**
     * M 行 N 列 的二维数组的转置(交换行和列)
     */
    @Test
    public void _13(){

        int [][] arr= new int[5][6];
        int num = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = ++num;
            }
        }

        System.err.println(Arrays.deepToString(arr));
        System.err.println(arr.length);
        System.err.println(arr[0].length);

        int length = arr.length;
        int high = arr[0].length;

        int [][] newArr= new int[high][length];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                newArr[j][i] = arr[i][j];
            }
        }

        System.err.println(Arrays.deepToString(newArr));
        System.err.println(newArr.length);
        System.err.println(newArr[0].length);

    }


    /**
     * 接受一个整型参数 N , 返回不大于log(2)(N)的最大整数
     */
    @Test
    public void _14(){

        int n = -1;
        n = n >>> 1;

        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = n+1;
        System.err.println(n);

        int num = 1;
        int x = 0;
        while (num != 0){

            num = num >>> 1;
            ++x;
        }
        System.err.println(x-1);



    }

    @Test
    public void _16(){
        int n = 6;
        String ss = exRl(n);
        System.err.println(ss);
    }



    private String exRl(int n) {
        if(n <= 0) return "";
        return exRl(n - 3) + n + exRl(n - 2) + n;
    }


    @Test
    public void _18(){
        int a= 2;
        int b = 25;

        //2, 25 --> 50 //XXX
        System.err.println(mystery(a, b));

        //3, 11--> 33
        System.err.println(mystery(3, 11));

        //给定正整数, mystery(a,b)= a * b // NB
        //给定正整数, mystery2(a,b)= Math.pow(a, b) // NB

    }

    private int mystery(int a, int b) {
        if(b == 0)return 0;
        if(b % 2 == 0) return mystery(a + a, b /2);
        return mystery(a + a, b / 2) + a;
    }

    private int mystery2(int a, int b) {
        if(b == 0)return 0;
        if(b % 2 == 0) return mystery(a * a, b /2);
        return mystery(a * a, b / 2) * a;
    }

    @Test
    public void _19(){
        /**
         * {@link _dynamic_programming._take_the_stairs.TakeTheStairs.takeTheStairs()}
         */
        Map<Integer, Long> map = new HashMap<>();
        System.err.println(F(100, map));

    }

    private long F(int n, Map<Integer, Long> map) {

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(map.get(n) != null) return map.get(n);
        long num = F(n-1, map) + F(n-2, map);
        map.put(n, num);
        return num;
    }

}
