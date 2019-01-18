package _old.adpater.step1;

public class TurkeyAdapter<T extends Turkey> implements Duck{
	
	private T t;
	
	public TurkeyAdapter(T t) {
		this.t = t;
	}

	@Override
	public void quack() {
		t.gobble();
	}

	@Override
	public void fly() {
		t.fly();
	}
}
