package _book._algorithms_4th_edition._5_string._5_1_string_sort;

import java.util.Arrays;

/**
 * 键索引计数法
 * @author 734070824@qq.com
 * @date 2018/9/6 17:03
 */
public class KeyIndex {
    public static void main(String[] args) {
        Student[] a = {
                new Student("An", 2),
                new Student("Br", 3),
                new Student("Da", 3),
                new Student("Ga", 4),
                new Student("Ha", 1),
                new Student("Ja", 3),
                new Student("Jo", 4),
                new Student("Jon", 3),
                new Student("Ma", 1),
                new Student("Mar", 2),
                new Student("Mi", 2),
                new Student("Mo", 1),
                new Student("Ro", 2),
                new Student("Sm", 4),
                new Student("Ta", 3),
                new Student("Th", 4),
                new Student("Tho", 4),
                new Student("Wh", 2),
                new Student("Wi", 3),
                new Student("Wil", 4),
        };

        int N = a.length;

        int[] count = new int[6];
        int R = count.length;


        //计算出现频率
        Student[] aux = new Student[N];
        for (int i = 0; i < N; i++) {
            count[a[i].key() + 1] ++;
        }


        //将频率转化为索引
        for (int r = 0; r < R-1; r++) {
            count[r+1] += count[r];
        }

        System.err.println(Arrays.toString(count));

        //将元素分类
        for (int i = 0; i < N; i++) {
            aux[count[a[i].key()]++] = a[i];
        }

        //回写
        for (int i = 0; i < N; i++) {
            a[i] = aux[i];
        }

        System.err.println(Arrays.toString(aux));
        System.err.println(Arrays.toString(aux));
        System.err.println(Arrays.toString(a));

    }
}
