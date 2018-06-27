package _dynamic_programming._kings_and_gold_mines;

import java.util.*;

/**
 * @author 734070824@qq.com
 * @date 2018/6/26 17:47
 */
public class KingsAndGoldMinesApp {

    //500/5, 200/3, 300/4, 350/3, 400/5
//    public static int[] golds = {500,200,300,350,400};
//
//    public static int[] persons = {5,3,4,3,5};

    public static int[] golds = {400,500,200,300,350};

    public static int[] persons = {5,5,3,4,3};

    /**
     * 金矿数量 N, 工人数量 W, 金矿的黄金量为 G[], 金矿的用工量 p[]
     * - F(N, W) = 0 (N <= 1, W < P[0])
     * - F(N, W) = P[0] (N == 1, W >= P[0])
     * - F(N, W) = F(N -1, W) (N > 1, W < P[N - 1]) --> 总人数小于最后一个金矿所需人数, 最后一个就不需要挖了
     * - F(N, W) = Max(F(N - 1, W), F(N - 1, W - P[N - 1]) + G[N - 1]) (N > 1, W >= P[N - 1])
     */
    public static void main(String[] args) {
//        permutationAndCombination();
        int num = simpleRecursion(5, 10, golds, persons);
        System.err.println(num);
        int i = simpleRecursionCache(new HashMap<>(), 5, 10, golds, persons);
        System.err.println(i);

        int num2 = dynamicProgramming(5, 10, golds, persons);
        System.err.println(num2);
    }

    /**
        1	2	3	4	5	 6	 7 	 8	 9 	10
     1	0	0	0	0	400	400	400	400	400	400
     2	0	0	0	0	500	500	500	500	500	900
     3	0	0	200	200	500	500	700	700	700	900
     4	0	0	200	300	500	500	500	700	800	900
     5	0	0	350	350	500	550	650	850	850	900
     * @param N
     * @param W
     * @param G
     * @param P
     * @return
     */
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

    /**
     * 简单递归
     * 把状态转移方程式翻译成递归程序，递归的结束的条件就是方程式当中的边界。因为每个状态有两个最优子结构，所以递归的执行流程类似于一颗高度为N的二叉树。
     */
    public static int simpleRecursion(int N, int W, int[] G, int [] P){
        if(N <= 1 && W < P[0]) return 0;
        if(N == 1 && W >= P[0]) return G[0];
        if(N > 1 && W < P[N-1]){
            int[] newG = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                newG[i] = G[i];
            }
            return simpleRecursion(N-1, W, newG, P);
        }
        if(N > 1 && W >= P[N-1]){
            int[] newG = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                newG[i] = G[i];
            }
            int num1 = simpleRecursion(N-1, W, newG, P);
            int[] newP = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                newP[i] = P[i];
            }
            int num2 = simpleRecursion(N-1, W - P[N - 1], newG,  newP) + G[N-1];
            return Math.max(num1, num2);
        }
        return 0;
    }

    /**
     * 在简单递归的基础上增加一个HashMap备忘录，用来存储中间结果。HashMap的Key是一个包含金矿数N和工人数W的对象，Value是最优选择获得的黄金数。
     * @param map
     * @param N
     * @param W
     * @param G
     * @param P
     * @return
     */
    public static int simpleRecursionCache(Map<String, Integer> map, int N, int W, int[] G, int [] P){
        if(map.get(N+"_" +W) != null) return map.get(N+"_" +W);
        if(N <= 1 && W < P[0]) return 0;
        if(N == 1 && W >= P[0]) return P[0];
        if(N > 1 && W < P[N-1]){
            int[] newG = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                newG[i] = G[i];
            }
            return simpleRecursion(N-1, W, newG, P);
        }
        if(N > 1 && W >= P[N-1]){
            int[] newG = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                newG[i] = G[i];
            }
            int num1 = simpleRecursion(N-1, W, newG, P);
            int[] newP = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                newP[i] = P[i];
            }
            int num2 = simpleRecursion(N-1, W - P[N - 1], newG,  newP) + G[N-1];
            int max = Math.max(num1, num2);
            map.put(N+"_" +W, max);
            return max;
        }
        return 0;
    }

    /**
     * 每一座金矿都有挖与不挖两种选择，
     * 如果有N座金矿，排列组合起来就有2^N种选择。
     * 对所有可能性做遍历，排除那些使用工人数超过10的选择，在剩下的选择里找出获得金币数最多的选择。
     * O(2^N)
     */
    public static void permutationAndCombination(){
        List<StringBuilder> l = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            if(l.isEmpty()){
                l.add(new StringBuilder().append(0));
                l.add(new StringBuilder().append(i));
            } else {
                List<StringBuilder> l2 = new ArrayList<>();
                for(StringBuilder sb : l){
                    l2.add(new StringBuilder().append(sb).append(0));
                    l2.add(new StringBuilder().append(sb).append(i));
                }
                l.clear();
                l.addAll(l2);
            }
        }
        System.err.println(Arrays.toString(l.toArray()));
    }

}
