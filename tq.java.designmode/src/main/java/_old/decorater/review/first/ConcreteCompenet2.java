package _old.decorater.review.first;

public class ConcreteCompenet2 extends Decorator{
	
	public ConcreteCompenet2(Component component) {
		super(component);
	}
	
	@Override
	public void doSomething() {
		super.doSomething();
		this.doAnotherThing();
	}
	
	public void doAnotherThing() {
		System.err.println("C");
	}

}
