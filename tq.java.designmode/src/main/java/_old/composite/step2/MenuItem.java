package _old.composite.step2;

public class MenuItem extends MenuComponet{

	
	private String name;
		
	private String description;
	
	boolean vegetarian;
	
	private double price;
	
	
	public MenuItem(String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}
	@Override
	public void print() {
		System.err.println("---MenuItem:"+name + "," + (isVegetarian()?"V":"NV") + "," + price + "," + description);
	}

	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public boolean isVegetarian() {
		return vegetarian;
	}


	public double getPrice() {
		return price;
	}

	
}
