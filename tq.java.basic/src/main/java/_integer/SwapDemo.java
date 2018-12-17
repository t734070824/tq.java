package _integer;

/**
 *两个Integer的引用对象传给一个swap方法在方法内部交换引用，返回后，两个引用的值是否会发现变化
 * @author 734070824@qq.com
 * @date 2018/12/17 10:44
 */
public class SwapDemo {

    public static void main(String[] args) {
        Integer l1 = 2;
        Integer l2 = 3;
        swap(l1,l2);
        System.err.println(l1 + "--" + l2);
    }

    private static void swap(Integer l1, Integer l2) {
        Integer tmp = l1;
        l1 = l2;
        l2 = tmp;
    }
}
