package _book._algorithms_4th_edition._5_string._5_1_string_sort;


import edu.princeton.cs.algs4.Insertion;

/**
 * 高位优先的字符串排序
 * @author 734070824@qq.com
 * @date 2018/9/8 14:40
 */
public class MSD {

    //基数
    private static int R = 256;

    //小数组的切换阈值
    private static final int M = 15;

    //数据分类的辅助数组
    private static String[] aux;

    private static int charAt(String s, int d){
        if(d < s.length()){
            return s.charAt(d);
        }else {
            return -1;
        }
    }

    public static  void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    /**
     * 排序
     * @param a
     * @param lo
     * @param hi
     * @param d 键 位
     */
    private static void sort(String[] a, int lo, int hi, int d) {
        //已第d个字符为键将 a[lo] 到 a[li] 排序
        // ???
        if(hi <= lo + M){
            Insertion.sort(a, lo, hi);
        }

        //计算频率
        int[] count = new int[R + 1];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) +2]++;
        }

        //频率转化为索引
        for (int r = 0; r < R+1; r++) {
            count[r+1] += count[r];
        }
        //数据分类
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1] ++ ] = a[i];
        }

        //回写
        for (int i = lo; i <= hi; i++) {
            a[i] =aux[i];
        }

        //递归的以每一个字符为键进行排序
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] -1, d+1);
        }

    }

}
