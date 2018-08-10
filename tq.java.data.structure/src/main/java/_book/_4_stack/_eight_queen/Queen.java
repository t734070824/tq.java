package _book._4_stack._eight_queen;

/**
 * 皇后类
 * @author 734070824@qq.com
 * @date 2018/8/10 15:38
 */
public class Queen {

    /**
     * 皇后在棋盘上的坐标
     */
    int x, y;

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 是否冲突
     * @param queen
     * @return
     */
    boolean conflict(Queen queen){
        /**
         * x2 - x1  = y1 - y2 --> (x + y == (queen.x + queen.y))
         * x2 - x1 = y2 - y1  --> ((x - y) == (queen.x - queen.y))
         */
        return (x == queen.x)
                || (y == queen.y)
                || (x + y == (queen.x + queen.y))
                ||  ((x - y) == (queen.x - queen.y));
    }
}
