package _other;

/**
 * 大于或等于输入参数且最近的2的整数次幂的数
 * @author 734070824@qq.com
 * @date 2018/3/21 14:26
 */
public class HighestOneBit {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        for (int i = 0; i < 60; i++) {
            System.err.println(i + "---" + tableSizeFor(i));
        }
    }


    /**
     * 先来假设n的二进制为01xxx...xxx。接着
     * 对n右移1位：001xx...xxx，再位或：011xx...xxx
     * 对n右移2为：00011...xxx，再位或：01111...xxx
     * 此时前面已经有四个1了，再右移4位且位或可得8个1
     * 同理，有8个1，右移8位肯定会让后八位也为1。
     * 综上可得，该算法让最高位的1后面的位全变为1。
     * 最后再让结果n+1，即得到了2的整数次幂的值了
     *
     * int n = cap - 1;
     * 让cap-1再赋值给n的目的是另找到的目标值大于或等于原值。
     * 例如二进制1000，十进制数值为8。如果不对它减1而直接操作，将得到答案10000，即16。
     * 显然不是结果。减1后二进制为111，再进行操作则会得到原来的数值1000，即8。
     * @param c
     * @return
     */
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
