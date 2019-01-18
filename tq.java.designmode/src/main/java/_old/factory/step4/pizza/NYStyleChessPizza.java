package _old.factory.step4.pizza;

public class NYStyleChessPizza implements Pizza{

	@Override
	public void perpare() {
		System.err.println("NYStyleChessPizza prepare");
	}

	@Override
	public void cut() {
		System.err.println("NYStyleChessPizza cut");
	}

	@Override
	public void box() {
		System.err.println("NYStyleChessPizza box");
	}

}
