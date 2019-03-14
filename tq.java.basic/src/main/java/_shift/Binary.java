package _shift;

/**
 * @author 734070824@qq.com
 * @date 2019/3/14 11:42
 */
public class Binary {

    public static void main(String[] args) {

        //计算出几位二进制数所能表示的最大十进制数
        long workerIdBits = 5L;
        long maxWorkerId = -1L ^ (-1L << workerIdBits);
        System.err.println(maxWorkerId);
        System.err.println(Long.toBinaryString(maxWorkerId));
        System.err.println(Long.toBinaryString(-1));
    }
}
