package _class_type;

public class TestArrClass {
	public static void main(String[] args) {
		int[][] arr = new int[2][2];
		System.err.println(arr.getClass());
		System.err.println(arr[0].getClass());
		System.err.println(arr[1].getClass());
		
	}
}
