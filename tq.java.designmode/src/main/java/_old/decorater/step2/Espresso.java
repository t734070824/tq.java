package _old.decorater.step2;

public class Espresso extends Beverage{
	
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 0.99;
	}

}
