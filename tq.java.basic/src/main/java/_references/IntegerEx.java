package _references;

/**
 * 交换Integer
 * @author 734070824@qq.com
 * @date 2018/9/14 16:46
 */
public class IntegerEx {

    public static void main(String[] args) {
        Integer l1 = new Integer(1);
        Integer l2 = new Integer(2);
        exchange(l1, l2);
        System.err.println(l1 + "--" + l2);
    }

    private static void exchange(Integer l1, Integer l2) {
        Integer tmp = l1;
        l1 = l2;
        l2 = tmp;
    }
}
