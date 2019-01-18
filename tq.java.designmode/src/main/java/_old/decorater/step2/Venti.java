package _old.decorater.step2;

public class Venti extends CondimentDecorator{

	private Beverage beverage;
	
	public Venti(Beverage beverage) {
		size = 1;
		this.beverage = beverage;
	}
	
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Venti";
	}

	@Override
	public double cost() {
		return 0.20;
	}
	

}
