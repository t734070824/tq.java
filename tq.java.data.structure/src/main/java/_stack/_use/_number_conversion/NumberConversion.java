package _stack._use._number_conversion;

import _stack.SeqStack;

import java.util.HashMap;
import java.util.Map;

/**
 * 数制转换
 * @author 734070824@qq.com
 * @date 2018/2/7 15:53
 */
public class NumberConversion {

    public final static int BINARY_SYSTEM = 2;

    public final static int OCTONARY_SYSTEM = 8;

    public final static int HEX_SYSTEM = 16;


    public static void main(String[] args) {
        ten2Other(164324, BINARY_SYSTEM);
        ten2Other(164324, OCTONARY_SYSTEM);
        ten2Other(164324, HEX_SYSTEM);
    }


    /**
     * 10进制转换为其他进制
     * @param n
     */
    public static void ten2Other(int n, int system){
        SeqStack<Character> stack = new SeqStack<>();
        while(n != 0){
            stack.push(Hex.getHex(n % system));
            n = n / system;
        }
        while (!stack.isEmpty()){
            System.err.print(stack.pop());
        }

        System.err.println("");

    }

    private enum Hex{
        _0(0,'0'),
        _1(1,'1'),
        _2(2,'2'),
        _3(3,'3'),
        _4(4,'4'),
        _5(5,'5'),
        _6(6,'6'),
        _7(7,'7'),
        _8(8,'8'),
        _9(9,'9'),
        _10(10,'A'),
        _11(11,'B'),
        _12(12,'C'),
        _13(13,'D'),
        _14(14,'E'),
        _15(15,'F'),


        ;

        int ten;
        char hex;

        Hex(int ten, char hex) {
            this.ten = ten;
            this.hex = hex;
        }

        static Map<Integer, Character> map = new HashMap<>();

        static {
            for(Hex o : values()){
                map.put(o.ten, o.hex);
            }
        }

        public static char getHex(int ten) {
            return map.get(ten);
        }
    }


}
