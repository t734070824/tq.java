package _ex03;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet{

	public void destroy() {
		System.err.println("destroy");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		System.err.println("init");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.err.println("from service");
		PrintWriter writer = response.getWriter();
		writer.println("Hello. TQ");
		writer.println("blue123AAAAAAAAsss");
	}

}
