package _longest_prefix_suffix;

/**
 *
 * @author 734070824@qq.com
 * @date 2018/6/29 15:27
 */
public class LongestPrefixSuffixApp {

    public static void main(String[] args) {
        String s = "";
        String l= longest(s);
        System.err.println(l + "--"+l.length());


        System.err.println(longest("ABCDABCD") + "--"+longest("ABCDAB").length());
        System.err.println(longest("ABC") + "--"+longest("ABC").length());
        System.err.println(longest("ABCD") + "--"+longest("ABCD").length());
        System.err.println(longest("ABCDA") + "--"+longest("ABCDA").length());
        System.err.println(longest("ABCDABD") + "--"+longest("ABCDABD").length());

    }

    /**
     * 最长公共前后缀
     * 先比较最长的, 然后一个一个减
     * --> KMP
     * @param s
     * @return
     */
    public static String longest(String s) {
        if(s.length() <= 1) return "";
        int len = s.length();
        for (int i = 0; i < len -1; i++) {
            String pre = s.substring(0, len - (i+1));
            String suf = s.substring(i+1);
            if(pre.equals(suf)) return pre;
        }
        return "";
    }
}
