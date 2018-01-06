package _oom._demo;

public class RunTimeConstantPoolOOM {

    //-XX:PermSize=10M -XX:MaxPermSize=10M
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.err.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.err.println(str2.intern() == str2);

        String str3 = new StringBuilder("ja").append("ttttqqq").toString();
        System.err.println(str3.intern() == str3);

        String str4 = new StringBuilder("计算机").append("软件").toString();
        System.err.println(str4.intern() == str4);

        //TODO intern()

    }
}
