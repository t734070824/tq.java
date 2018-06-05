package _nio._selector_channel;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author 734070824@qq.com
 * @date 2018/6/5 20:16
 */
public class SelectorChannelApp {

    public static void main(String[] args) throws IOException {
        Selector open = Selector.open();
        SocketChannel open1 = SocketChannel.open();
        open1.configureBlocking(false);
        open1.register(open, SelectionKey.OP_READ);
        SocketChannel open2 = SocketChannel.open();
        open2.configureBlocking(false);
        open2.register(open, SelectionKey.OP_READ);
        open.selectedKeys();

    }
}
