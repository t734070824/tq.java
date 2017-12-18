package _ex05;

import org.apache.catalina.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleWrapperValve  implements Valve, Contained{

    private Container container;

    private Servlet servlet;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public String getInfo() {
        return null;
    }

    public void invoke(Request request, Response response, ValveContext context) throws IOException, ServletException {
        SimpleWrapper wrapper = (SimpleWrapper) getContainer();
        ServletRequest sreq = request.getRequest();
        ServletResponse srep = response.getResponse();
        HttpServletRequest hreq = null;
        if(sreq instanceof  HttpServletRequest)
            hreq = (HttpServletRequest) sreq;
        HttpServletResponse hrep = null;
        if(srep instanceof  HttpServletResponse)
            hrep = (HttpServletResponse) srep;

        servlet = wrapper.allocate();
        if(hreq != null && hrep != null){
            servlet.service(hreq, hrep);
        }else {
            servlet.service(sreq, srep);
        }
    }
}
