package _old.decorater.step2;

public abstract class Beverage {
	
	public static final int TALL = 1;
	
	public static final int GRANDE = 2;
	
	public static final int VENTI = 3;
	
	int size;
	
	String description = "Unkown Beverage";

	public abstract double cost();
	
	public String getDescription() {
		return description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
