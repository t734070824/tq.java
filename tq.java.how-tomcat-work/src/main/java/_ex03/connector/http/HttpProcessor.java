package _ex03.connector.http;

import java.io.OutputStream;
import java.net.Socket;

import org.apache.tomcat.util.res.StringManager;

public class HttpProcessor {
	
	protected StringManager sm = StringManager.getManager("_ex03.connector.http");
	
	HttpRequest request = null;
	
	HttpResponse response = null;

	public void process(Socket socket) {
		SocketInputStream input = null;
		OutputStream output = null;
		
		try {
			input = new SocketInputStream(socket.getInputStream(), 2048);
			output = socket.getOutputStream();
			
			request = new HttpRequest(input);
			
			response = new HttpResponse(output);
			
			response.setRequest(request);
			
			response.setHeader("Server", "Pymont Servlet Container");
			
			parseRequest(input, output);
			
			parseHeader(input);
			
			if(request.getRequestURI().startsWith("/servlet/")) {
				ServletProcessor proccessor = new ServletProcessor();
				proccessor.process(request, response);
			}
			
			socket.close();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseHeader(SocketInputStream input) {
		// TODO Auto-generated method stub
		
	}

	private void parseRequest(SocketInputStream input, OutputStream output) {
		// TODO Auto-generated method stub
		
	}

}
