package _old.templatemethod.step2;

public class Tea extends CoffeineBeverage{

	@Override
	public void addCondiments() {
		System.err.println("add lemon");
	}

	@Override
	public void brew() {
		System.err.println("steep Tea bag");
	}

}
