package _ex03.connector.http;

import java.io.OutputStream;
import java.net.Socket;

import javax.servlet.ServletException;

import org.apache.catalina.util.StringManager;


public class HttpProcessor {
	
	protected StringManager sm = StringManager.getManager("_ex03.connector.http");
	
	HttpRequest request = null;
	
	HttpResponse response = null;
	
	private HttpRequestLine requestLine = new HttpRequestLine();

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

	private void parseRequest(SocketInputStream input, OutputStream output) throws ServletException {
		input.readRequestLine(requestLine);
		String method = new String(requestLine.method, 0, requestLine.methodEnd);
		String uri = null;
		String protocol  = new String(requestLine.protocol, 0, requestLine.protocolEnd);
		if(method.length() < 1) {
			throw new ServletException("Missing HTTP request method");
		}
		if(requestLine.uriEnd < 1) {
			throw new ServletException("Missing HTTP request URI");
		}
		int question = requestLine.indexof("?");
		if(question >= 0) {
			request.SetQueryString(new String(requestLine.uri, question + 1, requestLine.uriEnd - question - 1));
			uri = new String(requestLine.uri, 0, question);
		} else {
			request.SetQueryString(null);
			uri = new String(requestLine.uri, 0, requestLine.uriEnd);//????????
		}
		
		if(!uri.startsWith("/")) {
			int pos = uri.indexOf("://");
			if(pos != -1) {
				pos = uri.indexOf("/", pos + 3);
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
			if(semicolon2 >= 0) {
				request.SetRequestSessionId(rest.substring(0,semicolon2));
				rest = uri.substring(semicolon2);
			} else {
				request.SetRequestSessionId(rest);
				rest = "";
			}
		} else {
			request.SetRequestSessionId(null);
			request.SetRequestSessionURL(false);
		}
		
		String normalizedUri = normalize(uri);
		((HttpRequest)request).setMethod(method);
		request.setProtocol(protocol);
		if(normalizedUri != null) {
			((HttpRequest)request).setRequestURI(normalizedUri);
		} else {
			((HttpRequest)request).setRequestURI(uri);
		}
		
		if(normalizedUri == null) {
			throw new ServletException("Invalid URI:" + uri );
		}
		
		
		
		
		
	}

	private String normalize(String uri) {
		// TODO Auto-generated method stub
		return null;
	}

}
