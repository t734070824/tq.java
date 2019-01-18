package _old.iterator.step3;

import java.util.ArrayList;

public class PancakeHouseMenu implements Menu<MenuItem>{

	ArrayList<MenuItem> arrayList;
	
	public PancakeHouseMenu() {
		arrayList = new ArrayList<>();
		addItem("A", "AA", true, 1.2);
		addItem("B", "BB", false, 1.2);
		addItem("C", "CC", true, 1.2);
	}

	private void addItem(String name, String desc, boolean vegetarian, double price) {
		MenuItem item = new MenuItem(name, desc, vegetarian, price);
		arrayList.add(item);
	}

	@Override
	public Iterator<MenuItem> createIterator() {
		return new BreakFastIntertor(arrayList);
	}
	
}
