package _book._algorithms_4th_edition._2_rank._2_1_elementary_sorting_algorithms;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * @author 734070824@qq.com
 * @date 2018/7/3 16:59
 */
public class SortCompare {

    public static double time(String alg, Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")) Insertion.sort(a);
        if(alg.equals("Selection")) Selection.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T)
    { // 使用算法1将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++)
        { // 进行一次测试（生成一个数组并排序)
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }
    public static void main(String[] args)
    {
        float t2_t1 = 0;
        for (int i = 0; i < 1000; i++) {
            int N = 1000;
            int T = 1000;
            String alg1 = "Insertion";
            String alg2 = "Selection";
            double t1 = timeRandomInput(alg1, N, T); // 算法1的总时间
            double t2 = timeRandomInput(alg2, N, T); // 算法2的总时间
            StdOut.printf("For %d random Doubles\n %s is" , N, alg1);
            StdOut.printf(" %.1f times faster than %s\n" , t2/t1, alg2);
            t2_t1+=t2/t1;
        }


        StdOut.printf(t2_t1+"");
    }
}
