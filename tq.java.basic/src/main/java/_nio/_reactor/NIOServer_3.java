package _nio._reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 经典Reactor模式中，尽管一个线程可同时监控多个请求（Channel），
 * 但是所有读/写请求以及对新连接请求的处理都在同一个线程中处理，
 * 无法充分利用多CPU的优势，
 * 同时读/写操作也会阻塞对新连接请求的处理。因此可以引入多线程，并行处理多个读/写操作
 */
public class NIOServer_2 {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(1234));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(selector.select() > 0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if(key.isAcceptable()){
                    ServerSocketChannel acceptServerChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = acceptServerChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.err.println("Accept:" + socketChannel.getRemoteAddress());
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if(key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    int read = socketChannel.read(allocate);
                    if(read <= 0){
                        socketChannel.close();
                        key.cancel();
                        System.err.println("error");
                        continue;
                    }
                    System.err.println("received:" + new String(allocate.array()));
                }
                selectionKeys.remove(key);
            }
        }

    }
}
