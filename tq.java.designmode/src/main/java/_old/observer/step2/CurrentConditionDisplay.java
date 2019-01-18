package _old.observer.step2;

import _old.observer.step1.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement{
	
	Observable o;
	
	private float temperature;
	
	private float humidity;
	
	@Override
	public void display() {
		System.err.println("Temp:" + temperature + "--hum" + humidity);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData){
			WeatherData weatherData = (WeatherData)o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

}
