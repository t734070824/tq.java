package _lambda;

import java.util.function.Function;

/**
 * @author 734070824@qq.com
 * @date 2019/4/29 10:04
 */
public class FunctionDemo {

    static void modifyTheValue(int v, Function<Integer, Integer> function){
        int newV = function.apply(v);
        System.err.println(newV);

    }

    public static void main(String[] args) {
        int myNum = 26;
        modifyTheValue(26, val -> val + 2);
    }
}
