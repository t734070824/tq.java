package _book._1_introduction._recursion;

/**
 * @author 734070824@qq.com
 * @date 2018/8/3 10:39
 */
public class ArrReversal {

    void reverse(int[] A, int lo, int hi){
        if(lo < hi){
            //swap(A[lo], A[hi]);
            reverse(A, lo + 1, hi -1);
        }
        /**
         * else 隐藏的两种递归基
         * O(hi - lo + 1)
         */
    }

    void reverse_while_1(int[] A, int lo, int hi){
        while(lo < hi){
            //swap(A[lo], A[hi]);
            lo ++;
            hi --;
        }
        /**
         * else 隐藏的两种递归基
         * O(hi - lo + 1)
         */
    }

    void reverse_while_2(int[] A, int lo, int hi){
        while(lo < hi){
            //swap(A[lo++], A[hi--]);

        }
        /**
         * else 隐藏的两种递归基
         * O(hi - lo + 1)
         */
    }
}
