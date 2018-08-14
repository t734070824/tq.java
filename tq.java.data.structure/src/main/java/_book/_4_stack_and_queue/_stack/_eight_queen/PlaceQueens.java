package _book._4_stack_and_queue._stack._eight_queen;

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
        Queen old = null;
        solu.push(queen);
        int index = 1;
        while (queen.x < N || solu.size() < N){
            //保持上一个皇后
            queen = old != null ? old : new Queen(0, index);
            boolean find = false;
            while (queen.x < N){
                boolean choutu = false;
                for(Queen tmp : solu){
                    //如果和其中任何一个皇后冲突
                    if(tmp.conflict(queen)){
                        queen.x++;
                        choutu = true;
                        break;
                    }
                }

                //和已有的任何皇后不冲突, 放入
                if(!choutu){
                    solu.push(queen);
                    find = true;
                    break;
                }
            }
            //如果冲突, 移除并获取栈顶皇后, 继续
            if(!find){
                queen = solu.pop();
                index --;
                queen.x++;
                old  = queen;
            }else{
                //下一行
                index++;
                old = null;
            }

            if(solu.size() >= N){
                System.err.println(solu);
                break;
            }
        }
    }

    public static void main(String[] args) {
        placeQueens(4);
        placeQueens(5);
        placeQueens(6);
        placeQueens(7);
        placeQueens(8);
    }

}
