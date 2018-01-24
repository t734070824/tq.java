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
 * 多个Channel可以注册到同一个Selector对象上，
 * 实现了一个线程同时监控多个请求状态（Channel）。
 * 同时注册时需要指定它所关注的事件，
 * 例如上示代码中socketServerChannel对象只注册了OP_ACCEPT事件，
 * 而socketChannel对象只注册了OP_READ事件
 */
public class NIOServer_1 {

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
