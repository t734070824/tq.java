package _collection._list;

/**
 * 项目名:
 * 创建人:admin
 * 创建时间:2019/6/2313:55
 * 类名: ArrayListAReSize
 * 类描述:
 */
public class ArrayListAReSize {

    /**
     * 1.5倍
     * @param args
     */
    public static void main(String[] args) {
        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.err.println(newCapacity);
    }
}