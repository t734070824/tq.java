package _old.iterator.step3;

public class Waitress {
	
	private Menu<MenuItem> dinerMenu;
	
	private Menu<MenuItem> pancakeHouseMenu;
	
	public Waitress(Menu<MenuItem> dinerMenu, Menu<MenuItem> pancakeHouseMenu) {
		this.dinerMenu = dinerMenu;
		this.pancakeHouseMenu = pancakeHouseMenu;
	}
	
	public void printMenu() {
		Iterator<MenuItem> dinerItertor = dinerMenu.createIterator();
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator(); 
		System.err.println("----Breakfast----");
		printMenu(dinerItertor);
		System.err.println("----Lunch----");
		printMenu(pancakeIterator);
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while(iterator.hasNext()){
			System.err.println(iterator.next());
		}
	}

}
