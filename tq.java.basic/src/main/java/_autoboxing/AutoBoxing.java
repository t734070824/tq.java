package _autoboxing;

import java.util.HashMap;
import java.util.Map;

public class AutoBoxing {
	public static void main(String[] args) {
		Integer test1 = 233;
		Integer test2 = 233;
		boolean is = test1==test2;
		System.out.println(test1==test2);
		
		Map<Integer, Integer> map = new HashMap<>();
		int i = map.get(1);//nullPointEx;
		
	}
}
