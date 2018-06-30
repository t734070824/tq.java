package _book._algorithms_4th_edition._2_rank;

import edu.princeton.cs.algs4.StdOut;

/**
 * 插入排序
 * 在计算机的实现中， 为了给要插入的元素腾出空间， 我们需要将其余所有元素在插入之前都向右移
 动一位。 这种算法叫做插入排序
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

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) { // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();

    }

    public static boolean isSorted(Comparable[] a) { // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
