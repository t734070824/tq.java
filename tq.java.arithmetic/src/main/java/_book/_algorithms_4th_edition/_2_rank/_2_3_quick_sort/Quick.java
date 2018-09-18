package _book._algorithms_4th_edition._2_rank._2_3_quick_sort;

import _book._algorithms_4th_edition._2_rank._2_1_elementary_sorting_algorithms.RankUtil;

/**
 * 快速排序
 * @author 734070824@qq.com
 * @date 2018/9/18 17:38
 */
public class Quick {

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j -1);
        sort(a, j+1, hi);
    }

    /**
     * 切入点
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a, int lo, int hi) {
        //左右扫描指针
        int i = lo;
        int j = hi+1;
        //切分元素
        Comparable v = a[lo];
        while (true){
            while(RankUtil.less(a[++i], v)){
                if(i == hi) {
                    break;
                }
            }
            while (RankUtil.less(v, a[--j])){
                if(i == lo){
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            RankUtil.exch(a, i, j);
        }
        //将 v 放入正确的位置
        RankUtil.exch(a, lo, j);
        //a[lo ... j-1] <= a[j] <= a[j+1 ... hi]
        return j;
    }

    public static void main(String[] args) {
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        int partition = partition(arr, 0, args.length-1);
        System.err.println(partition);

    }
}
