package _netty_in_action._1_core_structure;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.util.concurrent.TimeUnit;

/**
 * @author 734070824@qq.com
 * @date 2018/5/25 10:57
 */
public class BIOApp {
    private static final int port = 9099;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true){
            Socket accept = serverSocket.accept();
            InputStream in = accept.getInputStream();
            OutputStream outputStream = accept.getOutputStream();
            byte[] buffer = new byte[2048];
            int i = in.read(buffer);
            System.err.println(new String(buffer));
            String errorMessage = "HTP/1.1 404 File Not Found\r\n"
                    +"Content-type: text/html\r\n"
                    +"Content-length: 23 \r\n"
                    +"\r\n"
                    +"<h1>File Not Found</h1>";

            outputStream.write(errorMessage.getBytes());
        }

    }
}
