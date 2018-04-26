package _source_code._http_connector;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.http.HttpConnector;

/**
 * @author 734070824@qq.com
 * @date 2018/4/26 17:45
 */
public class HttpConnectorApp {

    public static void main(String[] args) throws LifecycleException {
        HttpConnector connector = new HttpConnector();
        connector.initialize();
        connector.start();
    }
}
