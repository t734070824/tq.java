package _old.decorater.step1;

public class Beverage {
	
	private String description;
	
	private boolean milk;
	
	private boolean soy;
	
	private boolean mocha;
	
	private boolean whip;
	
	
	public double cost(){
		double cost = 0;
		
		if(hasMilk())
			cost += 1;
		if(hasSoy())
			cost += 2;
		if(hasMocha())
			cost += 3;
		if(hasWhip())
			cost += 4;
		return cost;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean hasMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	public boolean hasSoy() {
		return soy;
	}

	public void setSoy(boolean soy) {
		this.soy = soy;
	}

	public boolean hasMocha() {
		return mocha;
	}

	public void setMocha(boolean mocha) {
		this.mocha = mocha;
	}

	public boolean hasWhip() {
		return whip;
	}

	public void setWhip(boolean whip) {
		this.whip = whip;
	}
	

}
