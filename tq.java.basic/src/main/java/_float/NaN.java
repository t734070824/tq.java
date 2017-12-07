package _float;

public class NaN {
	
	public static void main(String[] args) {
		System.err.println(1.0/0.0);
		System.err.println(1/0.0);
//		System.err.println(1/0);
		System.err.println(-99 % 100);
		
		
		System.out.println(Float.isNaN(0.0f / 0.0f));
		System.out.println(Double.isNaN(Math.sqrt(-1)));
		
		System.err.println("Double.NaN != Double.NaN-->" + (Double.NaN != Double.NaN));
	}

}
