package _book._algorithms_4th_edition._5_string._5_1_string_sort;

import java.util.Arrays;

/**
 * 低位优先字符串排序
 * @author 734070824@qq.com
 * @date 2018/9/7 11:21
 */
public class LSD {

    public static void sort(String[] a, int W){
        //通过前W个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W-1; d >= 0; d--) {
            //根据第d个字符用键索引计数法排序

            //计算出现频率
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1] ++;
            }

            //将频率转化为索引
            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }

            //将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            //回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }

        }
    }

    public static void main(String[] args) {
        String[] a = {"4PGC938","2IYE230","3CIO720","1ICK750","1OHV845","4JZY524","1ICK750","3CIO720","1OHV845","1OHV845","2RLA629","2RLA629","3ATW723"};
        sort(a, 7);
        System.err.println(Arrays.toString(a));
    }
}
