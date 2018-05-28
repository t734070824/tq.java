package _concurrenthashmap;

/**
 * @author 734070824@qq.com
 * @date 2018/5/28 16:58
 */
public class TableSizeFor_App {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            int initialCapacity = i;
            int result = tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1);
            System.err.println(i + "--" + (initialCapacity + (initialCapacity >>> 1)) + "--" +  result);
        }



    }


    /**
     * {link HighestOneBit}
     * @param c
     * @return
     */
    public static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
