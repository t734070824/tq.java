package _old.templatemethod.step1;

public class Tea {

	public Tea() {
		boilWater();
		steepTeaBag();
		pourInCupl();
		addLemon();
	}

	private void addLemon() {
		System.err.println("add lemon");
	}

	private void pourInCupl() {
		System.err.println("pour in cup");
	}

	private void steepTeaBag() {
		System.err.println("steep Tea bag");
	}

	private void boilWater() {
		System.err.println("boil water");
	}
}
