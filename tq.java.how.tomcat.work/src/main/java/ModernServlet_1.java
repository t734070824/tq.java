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
		System.err.println("init ModernServlet_1");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.err.println("from ModernServlet_1");
		PrintWriter writer = response.getWriter();
		writer.println("Hello. TQ33");
		writer.println("ModernServlet_1");
	}

}
