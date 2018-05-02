import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ModernServlet_1 implements Servlet{

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
		System.err.println("init ModernServlet");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.err.println("from ModernServlet");
		PrintWriter writer = response.getWriter();
		writer.println("Hello. TQ111");
		writer.println("ModernServlet");
	}

}
