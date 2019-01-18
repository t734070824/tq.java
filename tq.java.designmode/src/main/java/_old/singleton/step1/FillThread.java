package _old.singleton.step1;

public class FillThread implements Runnable{

	@Override
	public void run() {
		ChocolateBoiler instance = ChocolateBoiler.getInstance();
		while(instance.isEmpty()){
			System.err.println("****************");
			System.err.println(instance);
			instance.fill();
			System.err.println("fill");
			System.err.println("****************");
		}
	}

}
