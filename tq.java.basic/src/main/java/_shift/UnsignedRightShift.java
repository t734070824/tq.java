package _shift;

/**
 * @author 734070824@qq.com
 * @date 2018/3/21 14:49
 */
public class UnsignedRightShift {

    public static void main(String[] args) {
        /**
         * 00000000 00000000 00000000 11111111，无符号向右移动7位，
         * 得到的bits当然为：00000000 00000000 00000000 00000001
         */
        System.out.println(0xff >>> 7);


        /**
         * (byte)0xff 是一个byte，bits为： 11111111， 首先转换为int，
         * 其bits为：11111111 11111111 11111111 11111111， 向右边无符号移动7为，
         * 得到的结果bits是：00000001 11111111 11111111 11111111
         */
        System.out.println((((byte) 0xff) >>> 7));

        /**
         * (byte) 0xff 是一个byte，bits为： 11111111， 首先转换为int，
         * 其bits为：11111111 11111111 11111111 11111111，向右边无符号移动7为，
         * 得到的结果bits是：00000001 11111111 11111111 11111111，
         * 然后转换为byte，低位截取得到bits: 11111111, 在输出的时候转换为int，
         * 其bits为：11111111 11111111 11111111 11111111
         */
        System.out.println((byte) (((byte) 0xff) >>> 7));
    }
}
