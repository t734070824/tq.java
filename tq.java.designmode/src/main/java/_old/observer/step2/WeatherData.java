package _old.observer.step2;

import java.util.Observable;

public class WeatherData extends Observable{
	
	private float temperature;
	
	private float humidity;
	
	private float pressure;
	
	
	public void measurementChanged(){
		ischange();
		notifyObservers();
	}
	
	
	private void ischange() {
		setChanged();
	}


	public void setMeasurement(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}

	public float getTemperature() {
		return temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public float getPressure() {
		return pressure;
	}



}
