package _other;

/**
 * @author 734070824@qq.com
 * @date 2018/3/21 14:26
 */
public class HighestOneBit {

    public static void main(String[] args) {
        int initialCapacity = 0;

        initialCapacity = initialCapacity + (initialCapacity >>> 1) + 1;
    }
}
