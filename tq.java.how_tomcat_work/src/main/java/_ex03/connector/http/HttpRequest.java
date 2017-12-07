package _ex03.connector.http;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.catalina.util.ParameterMap;

public class HttpRequest {
	
	protected HashMap<String, String> headers = new HashMap<String, String>();
	
	protected ArrayList<String> cookies = new ArrayList<String>();
	
	protected ParameterMap parameters = null;
	
	
	public HttpRequest(SocketInputStream inputStream) {
		// TODO Auto-generated constructor stub
	}

	public String getRequestURI() {
		// TODO Auto-generated method stub
		return null;
	}

}
