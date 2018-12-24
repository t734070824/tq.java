package _nio._4_selector_channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author 734070824@qq.com
 * @date 2018/12/24 17:34
 */
public class isWritableClient {

    public static void main(String[] args) throws IOException {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8000));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("hello".getBytes());
            writeBuffer.flip();
            while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
                System.out.println("received : " + new String(readBuffer.array()));
            }
        } catch (IOException e) {
        }
    }
}
