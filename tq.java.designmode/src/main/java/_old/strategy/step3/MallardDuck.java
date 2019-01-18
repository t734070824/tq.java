package _old.strategy.step3;

public class MallardDuck extends Duck{
	
	public MallardDuck() {
		fly = new FlyWithWings();
		quack = new Quack();
	}

	@Override
	public void display() {
		System.err.println("mallardDuck display");
	}
	
	

}
