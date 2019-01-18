package _old.iterator.step2;

public class Main {
	
	public static void main(String[] args) {
		DinerMenu dinerMenu = new DinerMenu();
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		Waitress waitress = new Waitress(dinerMenu, pancakeHouseMenu);
		waitress.printMenu();
	}

}
