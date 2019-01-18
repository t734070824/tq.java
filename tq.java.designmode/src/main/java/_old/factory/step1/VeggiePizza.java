package _old.factory.step1;

public class VeggiePizza implements Pizza {

	@Override
	public void perpare() {
		System.err.println("VeggiePizza perpare");
	}

	@Override
	public void cut() {
		System.err.println("VeggiePizza cut");
	}

	@Override
	public void box() {
		System.err.println("VeggiePizza box");
	}

}
