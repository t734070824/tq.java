package _book._4_stack._maze;

/**
 * 迷宫单元状态
 * @author 734070824@qq.com
 * @date 2018/8/11 15:16
 */
public enum Status {

    /**
     * 原始可用的
     */
    ARAILABLE,

    /**
     * 在当前路径上的
     */
    ROUTE,

    /**
     * 所有方向均尝试失败后回溯过的
     */
    BACKTRACKED,

    /**
     * 不可使用的(墙)
     */
    WALL,



    ;


}
