package _algorithm._kmp;

/**
 * KMP算法
 * @author 734070824@qq.com
 * @date 2018/6/29 14:35
 */
public class KMPApp {

    //TODO getNext(String s)
    //TODO k = next[k]

    public static void main(String[] args) {

        String s = "AAAKODSDSJDHKSJDLS";
        String p = "JD";
        System.err.println(violentMatch(s, p));

    }

    /**
     * 暴力破解
     * @param s
     * @param p
     * @return
     */
    public static int violentMatch(String s, String p){
        int sl = s.length();
        int pl = p.length();
        int i = 0;
        int j = 0;
        while (i < sl && j < pl){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if(j == pl){
            return i - j;
        } else {
            return -1;
        }
    }


    /**
     * kmp
     * 最大公共前后缀
     * O(m+n)
     * @param s
     * @param p
     * @return
     */
    public static int kmp(String s, String p){
        int sl = s.length();
        int pl = p.length();
        int i = 0;
        int j = 0;
        while (i < sl && j < pl){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            } else {
                int[] next= getNext(p);
                j = next[j];
            }
        }

        if(j == pl){
            return i - j;
        } else {
            return -1;
        }
    }

    private static int[] getNext(String p) {
        char[] chars = p.toCharArray();
        int[] next = new int[chars.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < chars.length - 1) {
            if (k == -1 || chars[j] == chars[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;

    }


}
