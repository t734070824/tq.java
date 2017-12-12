package _ex04;

import java.io.IOException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.http.HttpConnector;

@SuppressWarnings("deprecation")
public class Bootstrap {
	
	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		SimpleContainer container = new SimpleContainer();
		connector.setContainer(container);
		
		try {
			connector.initialize();
			connector.start();
			
			
			System.in.read();
		} catch (LifecycleException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
