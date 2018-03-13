package _extend._type_cast;

/**
 * 强制类型转换 子-->父
 * @author 734070824@qq.com
 * @date 2018/3/3 9:36
 */
public class TypeCast {

    public static void main(String[] args) {
        A a = new A();
        C c = (C) a;

        System.err.println(a);
        System.err.println(c);
    }


}
