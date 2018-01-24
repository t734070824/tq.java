package _nio._asynchronization;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AsynchronizationIOClient {

    public static void main(String[] args) throws IOException {
        try {
            SocketChannel inChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

            inChannel.configureBlocking(false);

            ByteBuffer buf = ByteBuffer.allocate(1024);

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext())
            {
                String str = scanner.nextLine();
                buf.put((LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"\n"+str).getBytes());
                buf.flip();
                inChannel.write(buf);
                buf.clear();
            }
            inChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
