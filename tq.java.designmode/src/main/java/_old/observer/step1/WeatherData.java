package _old.observer.step1;

import java.util.ArrayList;

public class WeatherData implements Subject{

	private ArrayList<Observer> obeservers;
	
	private float temperature;
	
	private float humidity;
	
	private float pressure;
	
	public WeatherData() {
		obeservers = new ArrayList<>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		if(obeservers.indexOf(o) < 0)
			obeservers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		if(obeservers.indexOf(o) >= 0)
			obeservers.remove(o);
	}

	@Override
	public void notifyObeservers() {
		for (Observer observer : obeservers) {
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementChanged() {
		notifyObeservers();
	}
	
	public void setMeasurement(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}

}
