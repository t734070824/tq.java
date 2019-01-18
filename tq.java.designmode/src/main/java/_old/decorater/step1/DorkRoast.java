package _old.decorater.step1;

public class DorkRoast extends Beverage{
	
	private double cost;
	
	public DorkRoast() {
		this.setDescription("Most Excellent Dark Roast");
	}
	
	@Override
	public double cost() {
		return cost + super.cost();
		
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
