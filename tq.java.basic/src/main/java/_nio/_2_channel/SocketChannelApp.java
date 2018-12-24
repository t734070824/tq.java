package _nio._2_channel;

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
        socketChannel.connect(new InetSocketAddress("192.168.7.183", 8000));

        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putInt(36);
        //***
        allocate.flip();
        socketChannel.write(allocate);

    }
}
