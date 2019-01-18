package _old.adpater.step3;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("TQ");
		list.add("123");
		ArrayListAdapter<String> adapter = new ArrayListAdapter<>(list.iterator());
		while (adapter.hasMoreElements()) {
			System.err.println(adapter.nextElement());
		}
	}

}
