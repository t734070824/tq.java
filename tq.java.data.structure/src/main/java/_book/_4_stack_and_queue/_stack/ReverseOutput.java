package _book._4_stack;

import java.util.Stack;

/**
 * @author 734070824@qq.com
 * @date 2018/8/8 17:26
 */
public class ReverseOutput {

    public final static char[] DIGIT = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};




    /**
     * 递归方式
     * @param n
     * @param base
     * @param stack
     */
    public static void convertDiGui(int n, int base, Stack<Character> stack){
        if(n > 0){
            convertDiGui(n / base, base, stack);
            stack.push(DIGIT[n % base]);
        }
    }

    /**
     * 10进制转化为其他进制,  迭代实现
     * @param n
     * @param otherSystem
     * @return
     */
    public static int ten2Other(int n, int otherSystem){
        Stack<Integer> stack = new Stack<>();
        while (n > 0){
            int tmp = n / otherSystem;
            int x = n % otherSystem;
            stack.push(x);
            n = tmp;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return Integer.valueOf(sb.toString());

    }

    public static void main(String[] args) {
        System.err.println(ReverseOutput.ten2Other(12345, 8));
        Stack<Character> stack = new Stack<>();
        ReverseOutput.convertDiGui(12345, 8, stack);
        System.err.println(stack);
    }

}
