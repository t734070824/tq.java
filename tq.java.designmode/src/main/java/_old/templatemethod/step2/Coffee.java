package _old.templatemethod.step2;

public class Coffee extends CoffeineBeverage{

	@Override
	public void addCondiments() {
		System.err.println("add suger and milk");
	}

	@Override
	public void brew() {
		System.err.println("bres coffee grinds");
	}

}
