package _nio._reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author 734070824@qq.com
 * @date 2018/6/5 20:40
 */
public class SocketChannelApp {

    public static void main(String[] args) throws IOException {
        // 打开一个通道
        SocketChannel socketChannel = SocketChannel.open();
        // 发起连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 1234));

        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putInt(36);
        socketChannel.write(allocate);

    }
}
