package _old.adpater.step1;

public class MallardDuck implements Duck {

	@Override
	public void quack() {
		System.err.println("Quack");
	}

	@Override
	public void fly() {
		System.err.println("Duck am fly");
	}

}
