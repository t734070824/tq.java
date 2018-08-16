package _book._algorithms_4th_edition._2_rank._2_2_merge_rank;

import org.junit.Assert;

import java.util.Arrays;

import static _book._algorithms_4th_edition._2_rank.RankUtil.*;

/**
 * 归并排序
 * 自底向上的归并
 * @author 734070824@qq.com
 * @date 2018/8/15 17:05
 */
public class MergeBU {


    private static Comparable[] aux;

    /**
     *  自底向上
     *  理解sz的作用
     * @param a
     */
    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        //进行lgN次两两归并
        for(int sz = 1; sz < N; sz = sz + sz){
            for(int lo=0; lo < N -sz; lo += sz + sz){
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }

        }
    }

    /**
     * 原地归并
     * 需要归并的两个数组都是有序的
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi){
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
