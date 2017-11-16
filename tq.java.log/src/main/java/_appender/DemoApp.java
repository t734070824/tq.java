package _appender;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DemoApp {
	static Logger log = LogManager.getLogger(DemoApp.class.getName());  
	
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while(true) {
			i++;
			log.error("123" + i);
			TimeUnit.MICROSECONDS.sleep(10);
		}
	}
}
