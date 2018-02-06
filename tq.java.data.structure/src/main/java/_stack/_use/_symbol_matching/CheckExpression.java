package _stack._use._symbol_matching;

import _stack.SeqStack;

public class CheckExpression {


    public static void main(String[] args) {
        String expstr="((5-3)*8-2)";
        System.out.println(expstr+"  "+isValid(expstr));

        String expstr2="((5-3)*8-2";
        System.out.println(expstr2+"  "+isValid(expstr2));

        String expstr3="(5-3)*8-2)";
        System.out.println(expstr3+"  "+isValid(expstr3));
    }


    public static String isValid(String expstr){
        SeqStack<String> stack = new SeqStack<>();
        int index = 0;
        while (index < expstr.length() ){
            char c = expstr.charAt(index++);
            switch (c){
                case '(':
                    // 左括号直接push
                    stack.push(c + "");
                    break;
                case ')':
                    //一个有括号必须对应一个左括号
                    if(stack.isEmpty() || !stack.pop().equals("(")) return "(";
                default:
                    break;
            }
        }
        //最后检测是否为空,为空则检测通过
        if(stack.isEmpty())
            return "check pass!";
        else
            return "check exception!";
    }


}
