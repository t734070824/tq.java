package _stack._use._maze;

/**
 * 迷宫格子
 * @author 734070824@qq.com
* @date 2018/2/7 16:28
 */
public class Cell {

    //坐标
    int x, y;

    //0--通道, 1--墙
    char c;

    //是否访问过
    boolean isVisited;

    public Cell(int x, int y, char c, boolean isVisited) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.isVisited = isVisited;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", c=" + c +
                ", isVisited=" + isVisited +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
