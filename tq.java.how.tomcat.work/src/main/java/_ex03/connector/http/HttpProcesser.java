package _ex03.connector.http;

import java.io.OutputStream;
import java.net.Socket;

import javax.servlet.ServletException;

public class HttpProcesser {
	
	HttpRequest request;
	HttpResponse response;
	private HttpRequestLine requestLine = new HttpRequestLine();

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void parseHeader(SocketInputStream inputStream) {
		//
		
	}

	private void parseRequest(SocketInputStream inputStream, OutputStream out) throws ServletException {
		inputStream.readRequestLine(requestLine);
		String method = new String(requestLine.method, 0, requestLine.methodEnd);
		String uri = null;
		String protocol = new String(requestLine.protocol, 0, requestLine.protocolEnd);
		if(method.length() < 1) {
			throw new ServletException("Missing HTTP method");
		}
		if(requestLine.uriEnd < 1) {
			throw new ServletException("Missing HTTP URI");
		}
		
		int question = requestLine.indexof("?");
		if(question >= 0) {
			request.setQueryString(new String(requestLine.uri, question + 1, requestLine.uriEnd - question - 1));
			uri = new String(requestLine.uri, 0, question);
		}
		
		if(!uri.startsWith("/")) {
			int pos = uri.indexOf("://");
			if(pos != -1) {
				pos = uri.indexOf('/', pos + 3);
				if(pos == -1) {
					uri = "";
				} else {
					uri = uri.substring(pos);
				}
			}
		}
		
		String match = ";jsessionid=";
		int semicolon = uri.indexOf(match);
		if(semicolon >= 0) {
			String rest = uri.substring(semicolon + match.length());
			int semicolon2 = rest.indexOf(";");
			if(semicolon >= 0) {
				request.setRequestedSessionId(rest.substring(0, semicolon2));
				rest = rest.substring(semicolon2);
			} else {
				request.setRequestedSessionId(rest);
				rest = "";
			}
			request.setRequestedSessionURL(true);
			
			uri = uri.substring(0, semicolon) + rest;
			
		} else {
			request.setRequestedSessionId(null);
			request.setRequestedSessionURL(false);
		}
		
		
		String normalizedUri = normalize(uri);
		request.setMethod(method);
		request.setProtocol(protocol);
		if(normalizedUri != null) {
			request.setRequestURI(normalizedUri);
		} else {
			request.setRequestURI(uri);
		}
		
		if(normalizedUri == null) {
			throw new ServletException("Invalid URI:" + uri);
		}
		
		
		
		
	}

	private String normalize(String uri) {
		//
		return null;
	}

}




















































