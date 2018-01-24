package _nio._asynchronization;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class AsynchronizationIODemo {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);
        while(true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            Set selectedKeys = selector.selectedKeys();
            Iterator keyIterator = selectedKeys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = (SelectionKey) keyIterator.next();
                if (key.isAcceptable()) {
                    System.err.println("Acceptable");
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    //读取通道数据，监控读就绪状态
                    socketChannel.register(selector, SelectionKey.OP_READ);

                } else if (key.isConnectable()) {
                    System.err.println("Connectable");
                } else if (key.isReadable()) {
                    //获取选择器上准备就绪的通道
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    while (socketChannel.read(buf) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array()));
                        buf.clear();
                    }
                } else if (key.isWritable()) {
                    System.err.println("Writable");
                }
                keyIterator.remove();
            }
        }

    }
}
