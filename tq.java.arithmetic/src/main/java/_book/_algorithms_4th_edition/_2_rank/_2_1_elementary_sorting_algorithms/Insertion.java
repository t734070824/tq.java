package _book._algorithms_4th_edition._2_rank._2_1_elementary_sorting_algorithms;

import static _book._algorithms_4th_edition._2_rank._2_1_elementary_sorting_algorithms.RankUtil.*;

/**
 * 插入排序
 * 在计算机的实现中， 为了给要插入的元素腾出空间， 我们需要将其余所有元素在插入之前都向右移
 动一位。 这种算法叫做插入排序
 * {@link tq.java.data.structure\src\main\java\_book\_3_list\readme.md}
 * @author 734070824@qq.com
 * @date 2018/6/30 16:47
 */
public class Insertion {

    public static void main(String[] args) {
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        sort(arr);
        assert isSorted(arr);
        show(arr);

    }

    public static void sort(Comparable[] a){
        //升序
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j >0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }

        }

    }


}
