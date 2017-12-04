package _sort;

import java.util.Arrays;

/**
 * 冒泡排序 正序
 * @author tangqing
 *
 */
public class BubblingReverse {
	
	public static int[] bubblingReverse(int[] arr) {
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = 0; j < arr.length -1 - i; j++) {
//				if(arr[j] > arr[j + 1]) {//从下到大
				if(arr[j] < arr[j + 1]) { //从大到小
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j] ^ arr[j + 1];
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		System.err.println(Arrays.toString(bubblingReverse(new int[] {12,123,34,53,3,5,567,576,7,67,868})));
		System.err.println(Arrays.toString(bubblingReverse(new int[] {56,4,534,6,46,46,4,64,56464,56,4646,456,4564,6})));
	}
}
