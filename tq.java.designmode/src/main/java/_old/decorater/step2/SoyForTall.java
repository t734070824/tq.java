package _old.decorater.step2;

public class SoyForTall extends CondimentDecorator{

	private Beverage beverage;
	
	public SoyForTall(Beverage beverage) {
		this.beverage = beverage;
	}
	
	public int getSize() {
		return beverage.getSize();
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Tall";
	}

	@Override
	public double cost() {
		double cost = beverage.cost();
		int size = getSize();
		if(size == Beverage.TALL)
			cost += 0.1;
		if(size == Beverage.GRANDE)
			cost += 0.15;
		if(size == Beverage.VENTI)
			cost += 0.2;
		return cost;
	}
	

}
