package _old.templatemethod.step1;

public class Coffee {
	
	public Coffee() {
		
		boilWater();
		brewCoffeeGrinds();
		pourInCup();
		addSugarAndMilk();
	}

	private void addSugarAndMilk() {
		System.err.println("add suger and milk");
	}

	private void pourInCup() {
		System.err.println("pour in cup");
	}

	private void brewCoffeeGrinds() {
		System.err.println("bres coffee grinds");
	}

	private void boilWater() {
		System.err.println("biol Water");
	}
	
	
	

}
