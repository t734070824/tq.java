package _extend._type_cast;

/**
 * 强制类型转换 子-->父
 * @author 734070824@qq.com
 * @date 2018/3/3 9:36
 */
public class TypeCast {

    public static void main(String[] args) {
        //Exception in thread "main" java.lang.ClassCastException: _extend._type_cast.A cannot be cast to _extend._type_cast.C
        //at _extend._type_cast.TypeCast.main(TypeCast.java:12)
//        A a = new A();
//        C c = (C) a;
//        System.err.println(a);
//        System.err.println(c);


        C c = new C();
        A a = c;
        C c2  = (C) a;
        System.err.println(a);
        System.err.println(c);
        System.err.println(c2);

    }


}
