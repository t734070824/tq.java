package _old.factory.step4.pizza;

public class ChicagoStyleChessPizza implements Pizza{

	@Override
	public void perpare() {
		System.err.println("ChicagoStyleChessPizza prepare");
	}

	@Override
	public void cut() {
		System.err.println("ChicagoStyleChessPizza cut");
	}

	@Override
	public void box() {
		System.err.println("ChicagoStyleChessPizza box");
	}

}
