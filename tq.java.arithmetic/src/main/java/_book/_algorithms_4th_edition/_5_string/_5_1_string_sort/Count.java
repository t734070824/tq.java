package _book._algorithms_4th_edition._5_string._5_1_string_sort;

import edu.princeton.cs.algs4.StdOut;

/**
 *
 * @author 734070824@qq.com
 * @date 2018/9/6 16:13
 */
public class Count {

    public static void main(String[] args) {
        String source = "ABCDR";
        Alphabet alphe = new Alphabet(source);
        int R = alphe.R();
        int[] count = new int[R];
        String s = "ABRACADABRA";
        int N = s.length();
//        for (int i = 0; i < N; i++) {
//            if(alphe.contains(s.charAt(i))){
//                count[alphe.toIndex(s.charAt(i))]++;
//            }
//        }

        int[] ints = alphe.toIndices(s);
        for (int i = 0; i < N; i++) {
            count[ints[i]] ++;
        }

        for (int c = 0; c < R; c++) {
            StdOut.println(alphe.toChar(c) + " " + count[c]);
        }
    }
}
