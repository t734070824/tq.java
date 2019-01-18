package _old.singleton.step1;

public class DrainThread implements Runnable{

	@Override
	public void run() {
		ChocolateBoiler instance = ChocolateBoiler.getInstance();
		while(!instance.isEmpty() && instance.isBoiled()){
			System.err.println("****************");
			System.err.println(instance);
			instance.drain();
			System.err.println("drain");
			System.err.println("****************");
		}
		
	}

}
