package _old.decorater.step2;

public class Decat extends Beverage{

	public Decat() {
		description = "Decat";
	}
	
	@Override
	public double cost() {
		return 3.99;
	}

}
