package _dynamic_programming._kings_and_gold_mines;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/26 17:47
 */
public class KingsAndGoldMinesApp {

    //500/5, 200/3, 300/4, 350/3, 400/5
    public static int[] golds = {500,200,300,350,400};

    public static int[] persons = {5,3,4,3,5};


    public static void main(String[] args) {

    }


    /**
     * 每一座金矿都有挖与不挖两种选择，
     * 如果有N座金矿，排列组合起来就有2^N种选择。
     * 对所有可能性做遍历，排除那些使用工人数超过10的选择，在剩下的选择里找出获得金币数最多的选择。
     * O(2^N)
     */
    public void permutationAndCombination(List<String> l){

        StringBuilder sb = new StringBuilder();

    }
}
