package _old.decorater.step2;

public class Grande extends CondimentDecorator{

	private Beverage beverage;
	
	public Grande(Beverage beverage) {
		size = 1;
		this.beverage = beverage;
	}
	
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Grande";
	}

	@Override
	public double cost() {
		return 0.15;
	}
	

}
