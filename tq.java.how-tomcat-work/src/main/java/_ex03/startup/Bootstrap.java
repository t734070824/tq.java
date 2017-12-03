package _ex03.startup;

import _ex03.connector.http.HttpConnector;

public class Bootstrap {

	public static void main(String[] args) {
		HttpConnector connector = new HttpConnector();
		connector.start();
	}
}
