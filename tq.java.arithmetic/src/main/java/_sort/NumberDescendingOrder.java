package _sort;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 数字降序
 * Input: 145263 Output: 654321
 * 
 * Input: 1254859723 Output: 9875543221
 * @author tangqing
 *
 */
public class NumberDescendingOrder {
	
	public static long numberDescendingOrder(long l) {
		String strL = Long.toString(l);
		int length = strL.length();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (l / (long)(Math.pow(10, length - i - 1)));
			l = l % (long)(Math.pow(10, length - i - 1));
		}
		System.err.println(Arrays.toString(arr));
		int[] bubblingSequence = BubblingReverse.bubblingReverse(arr);
		System.err.println(Arrays.toString(bubblingSequence));
		long r = 0;
		for (int i = 0; i < length; i++) {
//			r += bubblingSequence[i] * ((long)Math.pow(10, length - i - 1));
			long ss = (long) (bubblingSequence[i] * (Math.pow(10, length - i - 1)));
			System.err.println(length + "--" + i + "--" + ss);
			r += bubblingSequence[i] * (Math.pow(10, length - i - 1));
			System.err.println(r);
		}
		return r;
	}
	
	public static void main(String[] args) {
		System.err.println(numberDescendingOrder(654664343698346313L));
		System.err.println((long)(986666654444000000L + 3 * Math.pow(10, 18-13)));
		System.err.println((long)(3 * Math.pow(10, 18-13) * 10000000000000d));
		
		System.err.println((long)(1000000000000000000L + 3 * Math.pow(10, 18-13)));
		System.err.println(new BigDecimal(986666654444000000L).add(new BigDecimal(3 * Math.pow(10, 18-13))));

	}
}
