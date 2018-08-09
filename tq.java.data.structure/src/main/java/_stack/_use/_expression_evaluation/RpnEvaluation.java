package _stack._use._expression_evaluation;

import _stack.SeqStack;
import com.sun.deploy.util.StringUtils;

/**
 * @author 734070824@qq.com
 * @date 2018/8/9 19:39
 */
public class RpnEvaluation {

    public static double rpnEvaluation(String expression){
        SeqStack<Double> stack = new SeqStack<>();
        String[] split = expression.split(" ");
        int index = 0;
        while (index < split.length){
            String c = split[index];
            //运算符
            //计算
            if(!Character.isDigit(c.charAt(0))){
                double p2 = stack.pop();
                double p1 = stack.pop();
                //计算结果入栈
                stack.push(operate(p1, c.charAt(0), p2));
            }else {
                // 操作数入栈
                stack.push(Double.valueOf(c));
            }
            index++;
        }
        return stack.pop();
    }
    /**
     * 运算
     * @param opnd1 操作数1
     * @param optr 操作符
     * @param opnd2 操作数2
     * @return
     */
    private static double operate(double opnd1, char optr, double opnd2) {

        switch (optr) {
            case '+':
                return opnd1 + opnd2;
            case '-':
                return opnd1 - opnd2;
            case '*':
                return opnd1 * opnd2;
            case '/':
                return opnd1 / opnd2;
            case '^':
                return Math.pow(opnd1, opnd2);
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.err.println(rpnEvaluation("1 2 + 3 4 ^ *"));
    }
}
