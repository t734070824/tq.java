package _old.observer.step1;

public class CurrentConditionDisplay implements Observer, DisplayElement{

	private float temperature;
	
	private float humidity;
	
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.setWeatherData(weatherData);
		weatherData.registerObserver(this);
	}
	
	
	@Override
	public void display() {
		System.err.println("Temp:" + temperature + "--hum" + humidity);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.humidity = humidity;
		this.temperature = temp;
		display();
	}


	public Subject getWeatherData() {
		return weatherData;
	}


	public void setWeatherData(Subject weatherData) {
		this.weatherData = weatherData;
	}

}
