package _book._mybatis_jishu_neimu._2_basic_support_layer._2_reflector;

import _book._mybatis_jishu_neimu._1_introduction.Blog;
import org.apache.ibatis.reflection.Reflector;

/**
 * mybatis 反射工具箱
 * @author 734070824@qq.com
 * @date 2018/11/7 11:11
 */
public class ReflectorApp {

    public static void main(String[] args) {
        Reflector reflector = Reflector.forClass(Blog.class);
    }

}
