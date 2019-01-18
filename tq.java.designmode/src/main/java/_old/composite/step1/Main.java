package _old.composite.step1;

public class Main {
	
	public static void main(String[] args) {
		MenuComponet dinnerMenu = new Menu("DINNER MENU", "dinnerMenu");
		
		MenuComponet cafeMenu = new Menu("CAFEMENU", "cafeMenu");
		
		MenuComponet allMenus = new Menu("ALL MENUS", "allMenus");
		
		allMenus.add(dinnerMenu);
		allMenus.add(cafeMenu);
		
		dinnerMenu.add(new MenuItem("A", "AA", true, 1.2));
		dinnerMenu.add(new MenuItem("B", "BB", false, 1.2));
		
		cafeMenu.add(new MenuItem("C", "CC", true, 1.2));
		cafeMenu.add(new MenuItem("D", "DD", true, 1.2));
		
//		dinnerMenu.add(cafeMenu);
		
		Waitress waitress = new Waitress(allMenus);
		waitress.print();
	}

}
