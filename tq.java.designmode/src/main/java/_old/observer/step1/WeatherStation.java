package _old.observer.step1;

/**
 * 自己实现
 * @author tangqing
 *
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurement(6.2f, 50.0f, 20.2f);
		weatherData.setMeasurement(6.4f, 50.4f, 20.2f);
		weatherData.setMeasurement(6.7f, 50.7f, 20.2f);
	}
}
