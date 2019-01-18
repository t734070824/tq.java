package _old.factory.step2;

public class PrpperoniPizza implements Pizza {

	@Override
	public void perpare() {
		System.err.println("PrpperoniPizza perpare");
	}

	@Override
	public void cut() {
		System.err.println("PrpperoniPizza cut");
	}

	@Override
	public void box() {
		System.err.println("PrpperoniPizza box");
	}

}
