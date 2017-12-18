package _ex05;

import org.apache.catalina.Container;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Arrays;

public class SimpleLoader {

    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "tq.java.how_tomcat_work" + File.separator + "webroot";

    ClassLoader classLoader = null;
    Container container = null;

    public SimpleLoader() {
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classpath = new File(WEB_ROOT);
            String respository = (new URL("file", null, classpath.getCanonicalPath() + File.separator).toString());
            urls[0] = new URL(null, respository, streamHandler);
            classLoader = new URLClassLoader(urls);
        } catch (Exception e) {
            e.printStackTrace();;
        }

    }
}
