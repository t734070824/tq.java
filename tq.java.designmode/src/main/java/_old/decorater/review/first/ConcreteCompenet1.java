package _old.decorater.review.first;

public class ConcreteCompenet1 extends Decorator{

	public ConcreteCompenet1(Component component) {
		super(component);
	}

	
	@Override
	public void doSomething() {
		super.doSomething();
		this.doAnotherthing();
	}

	
	public void doAnotherthing(){
		System.err.println("B");
	}
}
