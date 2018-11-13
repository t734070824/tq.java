import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

/**
 * @author 734070824@qq.com
 * @date 2018/11/13 9:46
 */
public class HelloWorldServer {
    private static String ip = "localhost";

    public static void main(String[] args) {
        Undertow server = Undertow.builder().
                addHttpListener(8080, ip)
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(HttpServerExchange httpServerExchange) throws Exception {
                        httpServerExchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        httpServerExchange.getResponseSender().send("Hello world");
                    }
                }).build();
        server.start();
    }
}
