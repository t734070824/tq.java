package _classloader;

import java.net.URL;

/**
 * Bootstrap 加载的 calss
 * @author 734070824@qq.com
 * @date 2018/4/30 17:21
 */
public class BootstrapClassApp {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}
