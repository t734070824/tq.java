package _nio._reactor;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Processor_2 {

    private static final ExecutorService service = Executors.newFixedThreadPool(10);

    public void proces(SelectionKey selectionKey){
        service.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                int count = socketChannel.read(buffer);
                if (count < 0) {
                    socketChannel.close();
                    selectionKey.cancel();
                    System.err.println("{}\t Read ended"+ socketChannel);
                    return null;
                } else if(count == 0) {
                    return null;
                }
                System.err.println("{}\t Read message {}"+  socketChannel + "--" + new String(buffer.array()));
                return null;
            }
        });
    }
}
