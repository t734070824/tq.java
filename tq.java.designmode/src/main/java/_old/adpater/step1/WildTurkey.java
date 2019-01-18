package _old.adpater.step1;

public class WildTurkey implements Turkey{

	@Override
	public void gobble() {
		System.err.println("Gobble");
	}

	@Override
	public void fly() {
		System.err.println("Turkey fly");
	}

}
