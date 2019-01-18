package _old.factory.step3;

public class ChicagoStyleClamPizza implements Pizza{

	@Override
	public void perpare() {
		System.err.println("ChicagoStyleClamPizza prepare");
	}

	@Override
	public void cut() {
		System.err.println("ChicagoStyleClamPizza cut");
	}

	@Override
	public void box() {
		System.err.println("ChicagoStyleClamPizza box");
	}

}
