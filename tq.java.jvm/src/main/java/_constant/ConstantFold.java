package _constant;

/**
 * 常量折叠
 * 常量折叠是一种Java编译器使用的优化技术。由于final变量的值不会改变，因此就可以对它们优化
 * 通过反编译工具查看***
 * @author CTWLPC
 *
 */
public class ConstantFold {

	// 在行A的代码中，product的值是在编译期计算的，行B则是在运行时计算的
	static final int number1 = 5;
	static final int number2 = 6;
	static int number3 = 5;
	static int number4 = 6;

	public static void main(String[] args) {
		// line A
		int product1 = number1 * number2;
		System.err.println(product1);
		// line B
		int product2 = number3 * number4; 
		System.err.println(product2);

	}
}
