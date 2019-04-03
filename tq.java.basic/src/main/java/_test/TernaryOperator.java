package _test;

/**
 * @author 734070824@qq.com
 * @date 2019/4/3 19:41
 */
public class TernaryOperator {

    public static void main(String[] args) {
        String tail = "";
        String t = (tail = "oldTail");
        tail = "newTail";
        // <- 神奇吧
        boolean isEqual = t != (t = tail);
        // isEqual : true
        System.out.println("isEqual : "+isEqual);

    }
}
