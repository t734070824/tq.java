package _old.singleton.step1;


public class ChocolateBoiler{

	private boolean empty;
	
	private boolean boiled;
	
	public volatile static ChocolateBoiler instance;
	
	
	public static ChocolateBoiler getInstance() {
		if(instance == null){
			synchronized (ChocolateBoiler.class) {
				if(instance == null){
					instance = new ChocolateBoiler();
				}
			}
		}
			
		return instance;
	} 
	
//	public static ChocolateBoiler getInstance() {
//		if(instance == null)
//			instance = new ChocolateBoiler();
//		return instance;
//	}
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public synchronized void fill() {
		if(isEmpty()){
			empty = false;
			boiled = false;
		}
		
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()){
			empty = true;
		}
	}
	
	public void boiled() {
		if(!isEmpty() && !isBoiled()){
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void setBoiled(boolean boiled) {
		this.boiled = boiled;
	}
	
//	@Override
//	public String toString() {
//		return "empty:" + empty + "##boiler:" + boiled;
//	}
	
	
}
