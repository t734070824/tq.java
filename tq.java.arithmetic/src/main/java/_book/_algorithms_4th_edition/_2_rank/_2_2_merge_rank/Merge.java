package _book._algorithms_4th_edition._2_rank._2_2_merge_rank;

import _book._algorithms_4th_edition._2_rank.RankUtil;
import org.junit.Assert;

import java.util.Arrays;

import static _book._algorithms_4th_edition._2_rank.RankUtil.isSorted;
import static _book._algorithms_4th_edition._2_rank.RankUtil.less;
import static _book._algorithms_4th_edition._2_rank.RankUtil.show;

/**
 * 归并排序
 * 自顶向下的归并
 * @author 734070824@qq.com
 * @date 2018/8/15 17:05
 */
public class Merge {


    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }


    /**
     * 自顶向下的归并
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo){
            return;
        }
        /**
         * 理解 hi+lo 以及 hi-lo 的区别
         */
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);

    }

    /**
     * 原地归并
     * 需要归并的两个数组都是有序的
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        //a[lo, mid] a[mid+1, hi] 归并
        int i= lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        //归并会 a[lo, hi]
        for (int k = lo; k <= hi; k++) {
            // 右边还有数据
            if(i > mid) {
                a[k] = aux[j++];
            }else if(j > hi){
                a[k] = aux[i++];
            }else if(less(aux[j], aux[i])){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
            System.err.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
//        String[] arr = {"A","E","G","M","R","A","C","E","R","T"};
        sort(arr);
        Assert.assertTrue(isSorted(arr));
        show(arr);
    }
}
