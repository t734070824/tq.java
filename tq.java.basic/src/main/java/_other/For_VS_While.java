package _other;

/**
 * for 死循环 以及 while(true) 的区别
 *
 * @author 734070824@qq.com
 * @date 2018/4/3 15:04
 */
public class For_VS_While {
    public static void main(String[] args) {
        forTest();
        whileTest();
    }

    public static void forTest(){
        for(;;){
            System.out.println("for");
        }
    }

    public static void whileTest(){
        while (true){
            System.out.println("while");
        }
    }
}
