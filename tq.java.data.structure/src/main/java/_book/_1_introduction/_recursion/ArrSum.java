package _book._1_introduction._recursion;

/**
 * @author 734070824@qq.com
 * @date 2018/8/3 10:15
 */
public class ArrSum {

    /**
     * 线性递归,
     * O(n)
     * 空间: O(n)
     * @param A
     * @param n
     * @return
     */
    int sum(int A[], int n){
        if(n < 1){
            return 0;
        }else {
            return sum(A, n - 1) + A[n-1];
        }
    }

    /**
     *分而治之--二分递归
     * O(n)
     * 空间: O(logn)
     * @param A
     * @param lo
     * @param hi
     * @return
     */
    int sum(int A[], int lo, int hi){
        if(lo == hi){
            return A[lo];
        }else {
            int mi =  (lo + hi) >> 1;
            return sum(A, lo, mi) + sum(A, mi+1, hi);

        }
    }

}
