package _book._algorithms_4th_edition._2_rank;

import edu.princeton.cs.algs4.StdOut;

/**
 * 选择排序
 * 首先， 找到数组中最小的那个元素， 其次， 将它和数组的第
 一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换） 。 再次， 在剩下的元素中
 找到最小的元素， 将它与数组的第二个元素交换位置。 如此往复， 直到将整个数组排序。 这种方法
 叫做选择排序， 因为它在不断地选择剩余元素之中的最小者
 * @author 734070824@qq.com
 * @date 2018/6/30 16:27
 */
public class Selection {

    public static void main(String[] args) {
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        sort(arr);
        assert isSorted(arr);
        show(arr);

    }

    public static void sort(Comparable[] a){
        //升序
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
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
