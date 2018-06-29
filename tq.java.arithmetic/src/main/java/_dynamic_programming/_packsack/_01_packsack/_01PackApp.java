package _dynamic_programming._packsack._01_packsack;

import java.util.Arrays;

/**
 * @author 734070824@qq.com
 * @date 2018/6/29 11:17
 */
public class _01PackApp {

    public static void main(String[] args) {
        //有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]
        //5个物品，（重量，价值）分别为：（5，12），（4，3），（7，10），（2，3），（6，6）。
        int N = 5;
        int V = 10;
        int[] C = {5,4,7,2,6};
        int[] W = {12,3,10,3,6};
        System.err.println(dynamicProgramming(N, V, W, C));


    }

    public static int dynamicProgramming(int N, int W, int[] G, int [] P) {
        int[] preResult = new int[W];
        int[] result = new int[W];

        //填充边界
        for (int i = 0; i < W ; i++) {
            //第一列
            if((i+1) < P[0]){
                preResult[i] = 0;
            } else{
                preResult[i] = G[0];
            }
        }

        System.err.println(Arrays.toString(preResult));
        //填充其余格子的值 外层循环是 金矿数量, 内层循环是工人数

        for (int i = 2; i <= N; i++) {
            result = new int[W];
            for (int j = 1; j <= W; j++) {
                if((j) < P[i-1]){
                    result[j-1] = preResult[j-1];
                }else {
                    System.err.println(i+"--" + j);
                    result[j-1] = Math.max(preResult[j-1], preResult[(j - P[i-1]) == 0 ? 0 : ((j - P[i-1]) -1)] + G[i-1]);
                    System.err.println(i+"--" + j + "--" + result[j-1]);
                }
            }
            preResult = result;

            System.err.println(Arrays.toString(preResult));
        }

        return result[W-1];
    }
}
