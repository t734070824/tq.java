package _stack._use._expression_evaluation;

import _stack.SeqStack;

import java.util.EmptyStackException;

/**
 * 表达式求值
 * http://blog.csdn.net/gavin_john/article/details/71374487
 * @author 734070824@qq.com
 * @date 2018/2/26 14:00
 */
public class ExpressionEvaluation {

    public static void main(String[] args) {
        System.out.println(new ExpressionEvaluation().evaluate("4+(6-10+2*2)*2"));
    }

    private double evaluate(String expression) {

        SeqStack<Double> OPND_stack = new SeqStack<>();// 操作数栈
        SeqStack<Character> OPTR_stack = new SeqStack<>(); // 操作符栈

        //遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 如果当前字符是数字，也就是操作数
            if(Character.isDigit(c)){
                OPND_stack.push(Double.valueOf(c+""));
                continue;
            } else{
                // 当前的字符是操作符
                while (!OPTR_stack.isEmpty()) {
                    switch (precede(OPTR_stack.peek(), c)) {
                        case '<':
                            // 栈顶运算符小于该运算符，该运算符直接入栈
                            OPTR_stack.push(c);
                            break;
                        case '=':
                            // 栈顶运算符等于该运算符，只有一种情况，左右括号匹配，弹出左括号
                            OPTR_stack.pop();
                            break;
                        case '>':
                            // 栈顶运算符大小该运算符
                            char optr = OPTR_stack.pop();
                            // 如果有多余的操作符却没有操作数可以计算了，那么说明表达式错误
                            try {
                                double opnd2 = OPND_stack.pop();
                                double opnd1 = OPND_stack.pop();
                                OPND_stack.push(operate(opnd1, optr, opnd2));
                            } catch (EmptyStackException e) {
                                System.err.println("Character.isDigit(c)--表达式有误0！");
                                System.exit(0);
                            }
                            break;

                    }
                }

                // 第一次栈为空的情况，直接入栈。还有退栈直至栈为空的情况，当前操作符也需要入栈
                if (OPTR_stack.isEmpty()) {
                    OPTR_stack.push(c);
                }
            }

        }
        while (!OPTR_stack.isEmpty()) {
            char optr = OPTR_stack.pop();
            // 如果有多余的操作符却没有操作数可以计算了，那么说明表达式错误
            try {
                double opnd2 = OPND_stack.pop();
                double opnd1 = OPND_stack.pop();
                OPND_stack.push(operate(opnd1, optr, opnd2));
            } catch (EmptyStackException e) {
                System.err.println("!OPTR_stack.isEmpty() -- 表达式有误！");
                System.exit(0);
            }
        }
        if (OPND_stack.size() == 1) {
            return OPND_stack.pop();
        } else {
            System.err.println("OPND_stack.size() == 1 -- 表达式有误！");
            System.exit(0);
        }
        return 0;
    }

    /**
     * 运算
     * @param opnd1 操作数1
     * @param optr 操作符
     * @param opnd2 操作数2
     * @return
     */
    private double operate(double opnd1, char optr, double opnd2) {

        switch (optr) {
            case '+':
                return opnd1 + opnd2;
            case '-':
                return opnd1 - opnd2;
            case '*':
                return opnd1 * opnd2;
            case '/':
                return opnd1 / opnd2;
        }
        return 0;
    }

    private char precede(char θ1, char θ2) {
        if (θ1 == '+' || θ1 == '-') {
            if (θ2 == '+' || θ2 == '-' || θ2 == ')') {
                return '>';
            } else {
                return '<';
            }
        } else if (θ1 == '*' || θ1 == '/') {
            if (θ2 == '(') {
                return '<';
            } else {
                return '>';
            }
        } else if (θ1 == '(') {
            if (θ2 == ')') {
                return '=';
            } else {
                return '<';
            }
        }else if(θ1 == ')'){
            return '>';
        }
        return '>';
    }

}
