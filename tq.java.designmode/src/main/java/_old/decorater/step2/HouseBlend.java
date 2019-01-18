package _old.decorater.step2;

public class HouseBlend extends Beverage{

	public HouseBlend() {
		description = "HouseBlend";
	}
	
	@Override
	public double cost() {
		return 1.99;
	}

}
