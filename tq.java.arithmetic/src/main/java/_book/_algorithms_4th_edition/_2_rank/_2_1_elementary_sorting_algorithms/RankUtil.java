package _book._algorithms_4th_edition._2_rank._2_1_elementary_sorting_algorithms;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author 734070824@qq.com
 * @date 2018/7/3 17:40
 */
public class RankUtil {

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 在单行中打印数组
     * @param a
     */
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();

    }

    /**
     * 测试数组元素是否有序
     * @param a
     * @return
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
