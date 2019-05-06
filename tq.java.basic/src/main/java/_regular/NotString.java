package _regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 734070824@qq.com
 * @date 2018/12/13 10:35
 */
public class NotString {
    public static void main(String[] args) {
        String str = "123assume345contribute你好&*(){}&^%$#\n@@";

        //去除字符串中的数字
        System.out.println(str.replaceAll("\\d+", ""));

        //去除字符串中的字母和数字
        System.out.println(str.replaceAll("[A-Za-z0-9]+", ""));

        //去除字符串中的符号例如@#￥%=+-....
        System.out.println(str.replaceAll("\\p{Punct}", ""));


        str=" 123\n ";

        String str1 = null;
        //去除字符串中的空格、回车、换行符、制表符
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        str1 = m.replaceAll("");
        System.out.println(str1.trim().equals("123"));

        System.out.println("  123\n  ".trim().equals("123"));
    }

}
