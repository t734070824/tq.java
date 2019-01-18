package _old.factory.step3;

public class ChessPizza implements Pizza{

	@Override
	public void perpare() {
		System.err.println("ChessPizza prepare");
	}

	@Override
	public void cut() {
		System.err.println("ChessPizza cut");
	}

	@Override
	public void box() {
		System.err.println("ChessPizza box");
	}

}
