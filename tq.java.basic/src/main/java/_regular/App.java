package _regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 734070824@qq.com
 * @date 2018/11/21 14:21
 */
public class App {

    static Pattern javaW = Pattern.compile("debug$");

    static Pattern debug = Pattern.compile("^[dc|ct].*debug$");

    static Pattern release = Pattern.compile("^[dc|ct].*release$");


    public static void main(String[] args) {
        //返回true
        System.err.println(Pattern.matches("\\d+","2223"));

        //dc或ct开头的项目  debug 结尾则报测试版告警群 release 结尾则报正式版告警群

        System.err.println(javaW.matcher("123.debug123").find());

        System.err.println(javaW.matcher("123.debug123").find());

        System.err.println(debug.matcher("ct.123.debug").find());
        System.err.println(debug.matcher("dc.123.debug").find());

        System.err.println(release.matcher("ct.123.release").find());
        System.err.println(release.matcher("dc.123.release").find());


        Pattern pattern = Pattern.compile("您的短信验证码是：(.*?)【百世邻里】");
        Matcher matcher = pattern.matcher("您的短信验证码是：780951【百世邻里】");
        if(matcher.find()){
            System.err.println(matcher.group(0));
            System.err.println(matcher.group(1));
            System.err.println(matcher.group(2));
        }


    }
}
