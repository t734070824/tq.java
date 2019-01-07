package _exchange;

public class ExchangeWithOutTmp {
	
	public void exchangeXOR(int a, int b) {
		System.err.println("a-->" + a + "  b-->" + b);
		a = a ^ b;
		b = a ^ b;//b=(a^b)^b=a^(b^b)=a^0=a
		a = a ^ b;//a=(a^b)^a=b^(a^a)=b^0=b
		System.err.println("a-->" + a + "  b-->" + b);
	}
	
	//考虑溢出
	public void exchangeXOR(ExchangeNum num) {
		num.a = num.a + num.b;
		num.b = num.a - num.b;
		num.a = num.a - num.b;
	}
	
	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		int b = a + 1;
		
		ExchangeWithOutTmp e = new ExchangeWithOutTmp();
		e.exchangeXOR(a, b);
	}
	
}

