package _string;

/**
 * @author 734070824@qq.com
 * @date 2018/12/19 17:22
 */
public class Plus {

    public static void main(String[] args) {
        String s = "a";
        String s2 = s + "";
        System.out.println(s == s2);
        String s3 = "a" + "";
        System.out.println(s2 == s3);
        System.out.println(s == s3);

        /**
         * false
         * false
         * true
         */


        String _s = "ab";
        String _s2 = "a" + "b";
        System.err.println(_s ==_s2);
    }
}
