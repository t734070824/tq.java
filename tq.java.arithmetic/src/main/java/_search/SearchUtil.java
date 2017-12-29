package _search;

public class SearchUtil {

    /**
     * 二分法查找
     *要求 ： 数组从小到大排列
     * @param key
     * @param a
     * @return
     */
    public static int binarySearch(int key, int[] a){
        int head = 0;
        int tail = a.length - 1;
        while(head <= tail){
            int mid = head + (tail - head) / 2;
            if(key < a[mid]) tail = mid - 1;
            else if(key > a[mid])  head = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * 二分法查找 --> 递归
     *要求 ： 数组从小到大排列
     * @return
     */
    public static int binarySerach(int key, int[] a, int head, int tail){
        if(head > tail) return -1;
        int mid = (head + tail) / 2;
        if(key < a[mid]) binarySerach(key, a, head, mid - 1);
        else if(key > a[mid]) binarySerach(key, a, mid + 1, tail);
        else return mid;
        return -1;
    }
}
