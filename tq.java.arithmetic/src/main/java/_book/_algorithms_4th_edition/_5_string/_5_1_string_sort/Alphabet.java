package _book._algorithms_4th_edition._5_string._5_1_string_sort;

/**
 * 字母表
 * @author 734070824@qq.com
 * @date 2018/9/6 16:03
 */
public class Alphabet {

    private char[] chars;

    /**
     * 根据s中的字符创建一个新的字母表
     * @param s
     */
    public Alphabet(String s) {
        chars = s.toCharArray();
    }

    /**
     * 获取字母表中索引位置的字符
     * @param index
     * @return
     */
    char toChar(int index){
        return chars[index];
    }

    /**
     * 获取c的索引, 0-(R-1)
     * @param c
     * @return
     */
    int toIndex(char c){
        for (int i = 0; i < chars.length; i++) {
            if(c == chars[i]){
                return i;
            }
        }
        return -1;
    }

    boolean contains(char c){
        return toIndex(c) >= 0;
    }

    /**
     * 基数 字母表中的字符数量
     * @return
     */
    int R(){
        return chars.length;
    }

    /**
     * 表示一个索引需要的位数
     * @return
     */
    int lgR(){

        return 0;
    }

    /**
     * 将 s 转换为 R 进制的整数
     * @param s
     * @return
     */
    int[] toIndices(String s){
        int[] indexs = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            indexs[i] = toIndex(chars[i]);
        }
        return indexs;
    }

    /**
     * 将R进制的整数转换为基于该字母表的字符串
     * @param indices
     * @return
     */
    String toChars(int[] indices){

        return null;
    }


}
