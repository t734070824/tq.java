package _ex03.connector.http;

import java.io.OutputStream;

public class HttpResponse {

	HttpRequest request;
	
	public HttpResponse(OutputStream out) {
		//
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
		
	}

	public void setHeader(String key, String value) {
		
	}

}
