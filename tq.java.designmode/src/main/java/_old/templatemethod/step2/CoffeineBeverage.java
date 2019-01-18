package _old.templatemethod.step2;

public abstract class CoffeineBeverage {
	
	final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	public abstract void addCondiments();

	public abstract void brew();

	private void pourInCup() {
		System.err.println("pour in cup");
	}

	private void boilWater() {
		System.err.println("boil water");
	}

}
