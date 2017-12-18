package _ex05.startup;

import _ex05.SimpleLoader;
import _ex05.SimpleWrapper;
import _ex05.valve.ClientIPLoggerValve;
import _ex05.valve.HeaderLoggerValve;
import org.apache.catalina.*;
import org.apache.catalina.connector.http.HttpConnector;

@SuppressWarnings("deprecation")
public class Bootstrap1 {

    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        Wrapper wrapper = new SimpleWrapper();
        wrapper.setServletClass("PrimitiveServlet");
        Loader loader = new SimpleLoader();
        Valve valve1 = new HeaderLoggerValve();
        Valve valve2 = new ClientIPLoggerValve();

        wrapper.setLoader(loader);

        //TODO 仔细想想
        ((Pipeline)wrapper).addValve(valve1);
        ((Pipeline)wrapper).addValve(valve2);

        connector.setContainer(wrapper);
        try {
            connector.initialize();
            connector.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
