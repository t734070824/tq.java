package _book._4_stack._eight_queen;

import java.util.Stack;

/**
 * 放置皇后
 * @author 734070824@qq.com
 * @date 2018/8/10 16:25
 */
public class PlaceQueens {

    /**
     * N 皇后算法, 迭代版
     * 采用 试探, 回溯的策略, 借助栈记录查找的结果
     * @param N
     */
    public static void placeQueens(int N){

        //存放部分解的栈
        Stack<Queen> solu = new Stack<>();
        //从原点出发
        Queen queen = new Queen(0,0);
        solu.push(queen);
        int index = 1;
        while (queen.x < N || solu.size() < N){
            queen = new Queen(0, index);
            boolean find = false;
            while (queen.x < N){
                boolean choutu = false;
                for(Queen tmp : solu){
                    if(tmp.conflict(queen)){
                        queen.x++;
                        choutu = true;
                        break;
                    }
                }
                if(!choutu){
                    solu.push(queen);
                    find = true;
                    break;
                }
            }
            if(!find){
                queen = solu.pop();
                index --;
                queen.x++;
            }else{
                index++;
            }
        }

        System.err.println(solu);
    }

    public static void main(String[] args) {
        placeQueens(4);
    }

}
