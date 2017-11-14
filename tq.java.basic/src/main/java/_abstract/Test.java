package _abstract;

public abstract class Test {
	public abstract void save();
	
	public static void main(String[] args) {
		Test test = new TestAbstract();
		test.save();
	}
}
