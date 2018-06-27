package _dynamic_programming._take_the_stairs;

import java.util.Map;

/**
 * 走楼梯
 * @author 734070824@qq.com
 * @date 2018/6/12 17:42
 */
public class TakeTheStairs {
    public static void main(String[] args) {
        int level = 10;
        int num = takeTheStairsLowToHigh(level);
        System.err.println(num);

    }


    /**
     *                                      F(n)
*                                      /            /
*                                    F(n-1)         F(n-2)
     *                            /       /
     *                          F(n-1-1)  F(n-1-2)
     *  最终是一个二叉树, 高度为 n, 总量为 2^n -1, 时间复杂度为 O(2^n)
     *
     * @param level
     * @return
     */
    private static int takeTheStairs(int level) {
        if(level < 3) return 1;
        return takeTheStairs(level - 2) + takeTheStairs(level - 1);
    }

    /**
     * O(n)
     * @param level
     * @param map
     * @return
     */
    private static int takeTheStairsCache(int level, Map<Integer, Integer> map) {
        if(level < 3) return 1;
        if(map.containsKey(level)){
            return map.get(level);
        } else {
            int value = takeTheStairsCache(level - 2, map) + takeTheStairsCache(level - 1, map);
            map.put(level, value);
            return value;
        }

    }

    /**
     * 从低往高算, 时间复杂度 O(n) 空间复杂度 O(1)
     * level    1   2   3   4   5   6   7   8   9
     * num      1   2   3   5   8   13  21  34  55
     * @param level
     * @return
     */
    private static int takeTheStairsLowToHigh(int level) {
        if(level < 3) return 1;
        int a= 1;
        int b  = 2;
        int temp = 0;
        for (int i = 3; i < level; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }







}
