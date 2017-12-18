package _ex05.valve;

import org.apache.catalina.*;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import java.io.IOException;

public class ClientIPLoggerValve implements Valve, Contained {

    private Container container;
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
        context.invokeNext(request, response);
        System.err.println("Client IP Logger Valve");
        ServletRequest servletRequest = request.getRequest();
        System.err.println(servletRequest.getRemoteAddr());
        System.err.println("----------------------------");
    }
}
