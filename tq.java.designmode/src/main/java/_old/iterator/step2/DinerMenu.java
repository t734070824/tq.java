package _old.iterator.step2;

public class DinerMenu {
	
	private static final int MAX_ITEMS = 10;
	
	private int numberOfItems = 0;
	
	private MenuItem[] menuItems;
	
	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];
		addItem("D", "DD", true, 1.2);
		addItem("E", "EE", false, 1.2);
		addItem("F", "FF", true, 1.2);
	}
	
	private void addItem(String name, String desc, boolean vegetarian, double price) {
		if(numberOfItems >= MAX_ITEMS) return;
		MenuItem item = new MenuItem(name, desc, vegetarian, price);
		menuItems[numberOfItems] = item;
		numberOfItems++;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public DinerMenuIterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
	
}
