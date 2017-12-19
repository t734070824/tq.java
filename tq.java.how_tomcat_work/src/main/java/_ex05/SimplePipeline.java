package _ex05;

import org.apache.catalina.*;
import org.apache.catalina.core.Constants;
import org.apache.catalina.util.StringManager;

import javax.servlet.ServletException;
import java.io.IOException;

public class SimplePipeline implements Pipeline{

    private SimpleWrapper simpleWrapper;
    protected Valve valves[] = new Valve[0];

    private Valve basic;


    public SimplePipeline(SimpleWrapper simpleWrapper) {
        this.simpleWrapper = simpleWrapper;
    }

    public Valve getBasic() {
        return basic;
    }

    public void setBasic(Valve valve) {
        this.basic = basic;
    }

    public void addValve(Valve valve) {
        synchronized (valves) {
            Valve results[] = new Valve[valves.length +1];
            System.arraycopy(valves, 0, results, 0, valves.length);
            results[valves.length] = valve;
            valves = results;
        }

    }

    public Valve[] getValves() {
        return valves;
    }

    public void invoke(Request request, Response response) throws IOException, ServletException {
        new SimplePipelineValveContext().invokeNext(request, response);
    }

    public void removeValve(Valve valve) {

    }

    class SimplePipelineValveContext implements ValveContext{

        protected int stage = 0;

        public String getInfo() {
            return "tq";
        }

        public void invokeNext(Request request, Response response) throws IOException, ServletException {
            int subscript = stage;
            stage = stage + 1;

            // Invoke the requested Valve for the current request thread
            if (subscript < valves.length) {
                valves[subscript].invoke(request, response, this);
            } else if ((subscript == valves.length) && (basic != null)) {
                basic.invoke(request, response, this);
            } else {
                throw new ServletException
                        ("standardPipeline.noValve");
            }
        }
    }

}
