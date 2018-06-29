package _kmp;

import java.util.stream.IntStream;

/**
 * KMP算法
 * @author 734070824@qq.com
 * @date 2018/6/29 14:35
 */
public class KMPApp {

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

}
