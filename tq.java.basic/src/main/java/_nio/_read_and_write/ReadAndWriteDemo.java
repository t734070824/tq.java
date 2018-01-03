package _nio._read_and_write;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadAndWriteDemo {

    public static final String PATH = System.getProperty("user.dir")
            + "/tq.java.basic/src/main/java" + "/_nio/_read_and_write/";

    public static void main(String[] args) throws IOException {


        read();

        write();


    }

    private static void write() throws IOException {
        FileOutputStream fout = new FileOutputStream(PATH + "writesomebytes.txt");
        FileChannel channel = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        byte[] msg = "tq".getBytes();
        for (int i = 0; i < msg.length; i++) {
            buffer.put(msg[i]);
        }

        buffer.flip();
        channel.write(buffer);

    }

    private static void read() throws IOException {
        FileInputStream fin = new FileInputStream(PATH + "readandshow.txt");
        FileChannel channel = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        byte[] msg = new byte[buffer.remaining()];
        buffer.get(msg);

        System.err.println(new String(msg));

    }
}
