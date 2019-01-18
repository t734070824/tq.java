package _old.iterator.step2;

public class Waitress {
	
	private DinerMenu dinerMenu;
	
	private PancakeHouseMenu pancakeHouseMenu;
	
	public Waitress(DinerMenu dinerMenu, PancakeHouseMenu pancakeHouseMenu) {
		this.dinerMenu = dinerMenu;
		this.pancakeHouseMenu = pancakeHouseMenu;
	}
	
	public void printMenu() {
		Iterator<MenuItem> dinerItertor = dinerMenu.createIterator();
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createInterator(); 
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
