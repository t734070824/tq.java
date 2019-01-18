package _old.factory.step3;

public class ClamPizza implements Pizza {

	@Override
	public void perpare() {
		System.err.println("ClamPizza perpare");
	}

	@Override
	public void cut() {
		System.err.println("ClamPizza cut");
	}

	@Override
	public void box() {
		System.err.println("ClamPizza box");
	}

}
