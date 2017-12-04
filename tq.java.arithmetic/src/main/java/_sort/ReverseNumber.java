package _sort;

/**
 *  Write a program to reverse a number using numeric operations. 
 *  把数字倒序输出，只使用数字运算符
 **/
public class ReverseNumber {
	
	public static int reverseNumber(int paraNum) {
        int revNum = 0;
        // 关键也就是这三行的代码
        while(paraNum != 0){
            revNum =  paraNum % 10 + revNum * 10;
            paraNum /= 10;
        }
        return revNum;
	}
	
	public static void main(String[] args) {
		System.err.println(reverseNumber(123123145));
	}

}
