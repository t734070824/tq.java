package _ex03.connector.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class HttpProcesser {
	
	HttpRequest request;
	HttpResponse response;
	HttpRequestLine requestLine;

	public HttpProcesser(HttpConnector httpConnector) {
		
	}

	public void process(Socket socket) {
		SocketInputStream inputStream = null;
		OutputStream out = null;
		try {
			inputStream = new SocketInputStream(socket.getInputStream(), 2048);
			out = socket.getOutputStream();
			request = new HttpRequest(inputStream);
			
			response = new HttpResponse(out);
			response.setRequest(request);
			
			response.setHeader("Server", "Servlet Container");
			
			parseRequest(inputStream, out);
			
			parseHeader(inputStream);
			
			if(request.getRequestURI().startsWith("/servlet")) {
				ServletProcessor processer = new ServletProcessor();
				processer.process(request, response);
			}else {
				StaticResourceProcessor processor = new StaticResourceProcessor();
				processor.process(request, response);
			}
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void parseHeader(SocketInputStream inputStream) {
		// TODO Auto-generated method stub
		
	}

	private void parseRequest(SocketInputStream inputStream, OutputStream out) {
		inputStream.readRequestLine(requestLine);
	}

}
