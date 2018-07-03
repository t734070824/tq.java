package _book._algorithms_4th_edition._2_rank;
import static _book._algorithms_4th_edition._2_rank.RankUtil.*;

/**
 * 希尔排序
 * 希尔排序为了加快速度简单地改进了插入排序， 交换不相邻的元素以对数组的局部
 进行排序， 并最终用插入排序将局部有序的数组排序
 * @author 734070824@qq.com
 * @date 2018/7/3 17:39
 */
public class Shell {

    public static void main(String[] args) {
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        sort(arr);
        assert isSorted(arr);
        show(arr);
    }

    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j - h);
                }

            }
            h = h/3;
        }
    }

}
