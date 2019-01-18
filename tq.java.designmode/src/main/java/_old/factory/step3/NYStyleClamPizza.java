package _old.factory.step3;

public class NYStyleClamPizza implements Pizza {

	@Override
	public void perpare() {
		System.err.println("NYStyleClamPizza perpare");
	}

	@Override
	public void cut() {
		System.err.println("NYStyleClamPizza cut");
	}

	@Override
	public void box() {
		System.err.println("NYStyleClamPizza box");
	}

}
