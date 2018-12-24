package _nio._2_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author 734070824@qq.com
 * @date 2018/12/24 15:45
 */
public class WebServer {

    public static void main(String args[]) throws IOException {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("192.168.7.183", 8000));
            while (true){
                SocketChannel socketChannel = ssc.accept();

                ByteBuffer readBuffer = ByteBuffer.allocate(128);
                socketChannel.read(readBuffer);

                readBuffer.flip();
                while (readBuffer.hasRemaining()) {
                    System.out.println(readBuffer.get());
                }

                socketChannel.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
