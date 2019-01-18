package _old.singleton.step1;

public class BoildThread implements Runnable{

	@Override
	public void run() {
		ChocolateBoiler instance = ChocolateBoiler.getInstance();
		while (!instance.isBoiled() && !instance.isEmpty()) {
			System.err.println("****************");
			System.err.println(instance);
			instance.boiled();
			System.err.println("boiled");
			System.err.println("****************");
		}
	}

}
