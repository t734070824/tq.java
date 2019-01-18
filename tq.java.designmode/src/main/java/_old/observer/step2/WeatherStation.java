package _old.observer.step2;

/**
 * 借助java API 的内置 观察者模式
 * @author tangqing
 *
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		new CurrentConditionDisplay();
		weatherData.setMeasurement(6.2f, 50.0f, 20.2f);
		weatherData.setMeasurement(6.4f, 50.4f, 20.2f);
		weatherData.setMeasurement(6.7f, 50.7f, 20.2f);
	}

}
