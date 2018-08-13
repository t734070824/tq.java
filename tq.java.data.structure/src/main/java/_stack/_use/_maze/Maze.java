package _stack._use._maze;

import java.util.Stack;

/**
 * 迷宫求解
 * 初始化，将起点加入堆栈；
 * while(堆栈不为空){
 *     取出栈顶位置为当前位置；
 *     如果 当前位置是终点，
 *     则 使用堆栈记录的路径标记从起点至终点的路径；
 *     否则{
 *         按照从下、右、上、左的顺序将当前位置下一个可以探索的位置入栈；
 *         如果 当前位置的四周均不通
 *         则 当前位置出栈；
 *     }
 * }
 * @author 734070824@qq.com
 * @date 2018/2/7 16:26
 */
public class Maze {

    public static void main(String[] args) {
        char maze[][] = {
                { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '1', '1', '0', '0', '1', '1' },
                { '1', '0', '0', '1', '1', '0', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '0', '0', '0', '1', '0', '1' },
                { '1', '0', '0', '0', '0', '1', '1', '0', '0', '1' },
                { '1', '0', '0', '1', '1', '1', '0', '0', '0', '1' },
                { '1', '0', '0', '0', '0', '1', '0', '1', '0', '1' },
                { '1', '0', '1', '1', '0', '0', '0', '0', '0', '1' },
                { '1', '1', '0', '0', '0', '0', '1', '0', '0', '1' },
                { '1', '1', '1', '1', '1', '1', '1', '1', '1', '1' },
        };
        mazeExit(maze, 8, 8, 1, 7);
    }

    /**
     * 求解迷宫
     * @param maze 迷宫的字符数组
     * @param in_x 起点x坐标
     * @param in_y 起点y坐标
     * @param out_x 终点x坐标
     * @param out_y 终点y坐标
     */
    public static void mazeExit(char maze[][], int in_x, int in_y, int out_x, int out_y) {
        Cell[][] cells = createMaze(maze);
        printMaze(cells);
        Cell start = cells[in_x][in_y];
        Cell end = cells[out_x][out_y];
        Stack<Cell> stack = new Stack<>();
        stack.push(start);
        start.isVisited = true;
        while (!stack.isEmpty()) {
            Cell now = stack.peek();
            if (now.equals(end)) {
                // 找到路径
                int x = out_x;
                int y = out_y;
                while (!stack.isEmpty()) {
                    Cell cell = stack.pop();
                    // 要注意的是，只有和上一次的cell相邻的cell才是路径上的通道
                    if (Math.abs(cell.x - x) + Math.abs(cell.y - y) <= 1) {
                        cell.c = '*';
                    }
                    x = cell.x;
                    y = cell.y;
                }
                System.out.println("找到路径：");
                printMaze(cells);
                return;
            } else {
                // 向四个方向探索
                boolean isDead = true;
                for (int i = 0; i < 4; i++) {
                    Cell next_cell = getCell(cells, now, i);
                    if (isValid(next_cell)) {
                        next_cell.isVisited = true;
                        stack.push(next_cell);
                        isDead = false;
                    }
                }
                // 四个方向都不能走，则该点为死胡同，出栈
                if(isDead){
                    stack.pop();
                }

            }
        }
        System.err.println("找不到");
    }

    /**
     * 判断一个cell是否是通道
     * @param cell
     * @return
     */
    public static boolean isValid(Cell cell) {
        return cell.c == '0' && !cell.isVisited;
    }

    /**
     * 根据方向得到下一个cell
     * @param cells
     * @param now
     * @param direction
     * @return
     */
    public static Cell getCell(Cell[][] cells, Cell now, int direction) {
        int x = now.x;
        int y = now.y;
        Cell cell = null;
        switch (direction) {
            case 0:
                // 向下
                cell =  cells[x + 1][y];
                break;
            case 1:
                // 向右
                cell =  cells[x][y + 1];
                break;
            case 2:
                // 向上
                cell =  cells[x - 1][y];
                break;
            case 3:
                // 向左
                cell =  cells[x][y - 1];
                break;
        }
        return cell;
    }

    /**
     * 根据输入的二维char数组创建二维Cell数组
     *
     * @param maze
     *            二维char数组
     * @return
     */
    private static Cell[][] createMaze(char[][] maze) {
        Cell[][] cells = new Cell[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                char c = maze[i][j];
                Cell cell = new Cell(i, j, c, false);
                cells[i][j] = cell;
            }
        }
        return cells;
    }

    /**
     * 打印迷宫
     *
     * @param cells
     */
    private static void printMaze(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].c + " ");
            }
            System.out.println();
        }
    }
}

