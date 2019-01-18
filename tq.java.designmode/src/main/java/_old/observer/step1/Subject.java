package _old.observer.step1;

public interface Subject {
	
	public void registerObserver(Observer o);
	
	public void removeObserver(Observer o);

	
	public void notifyObeservers();
}
