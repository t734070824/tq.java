package _book._understanding_jvm._2_automatic_memory_management;

/**
 * StackOverFlowError 场景
 * @author 734070824@qq.com
 * @date 2018/9/19 10:46
 */
public class StackOverFlowErrorScene {

    static int num = 0;

    public static void main(String[] args) {
        recursion();
    }


    /**
     * 递归调用
     * default: 9884, 9942, 9910
     * -Xss1M: 9987
     * --Xss1M: 20055
     * 不固定
     */
    private static void recursion() {
        System.err.println(num++);
        recursion();
    }

}
