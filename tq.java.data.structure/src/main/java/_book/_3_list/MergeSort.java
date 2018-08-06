package _book._3_list;

import java.util.Arrays;

/**
 * @author 734070824@qq.com
 * @date 2018/8/6 19:58
 */
public class MergeSort {

    

    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if(low < high){
            //左边
            mergeSort(a, low, mid);
            //右边
            mergeSort(a,mid + 1, high);
            merge(a, low, mid, high);
        }

    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
        //先将较小的数放入tmp
        //数据量少的先放完
        while (i <= mid && j <= high){
            if(a[i] > a[j]){
                tmp[index++] = a[j++];
            }else {
                tmp[index++] = a[i++];
            }
        }

        //放入左边还未 放入的
        while (i <= mid){
            tmp[index++] = a[i++];
        }
        //放入右边还未 放入的
        while (j <= high) {
            tmp[index++] = a[j++];
        }

        //临时表放入 a 中
        for (int k = 0; k < tmp.length; k++) {
            a[k + low] = tmp[k];
        }

    }


}
