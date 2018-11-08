package _extend;

/**
 * 父类子类相同的变量
 * @author 734070824@qq.com
 * @date 2018/10/30 11:23
 */
public class SameVariableApp {

    public static void main(String[] args){

        B b = new B();

        System.out.println(b.x);
        System.out.println(((A)b).x);
        System.out.println(((A)b).getX());

        b.print();
        b.printSuper();
        ((A)b).print();

        System.out.println("==============");

        A a = new B();

        System.out.println(a.x);
        System.out.println(((B)a).x);
        System.out.println(((B)a).getX());

        a.print();

    }

}

class A {

    int x = 20;

    void print(){
        System.out.println(x);
    }

    public int getX() {
        return x;
    }
}

class B extends A{

    int x = 3;

    void print(){
        System.out.println(x);
    }

    void printSuper(){
        System.out.println(super.x);
    }

    @Override
    public int getX() {
        return x;
    }
}

