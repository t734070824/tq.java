package _demo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

/**
 * @author 734070824@qq.com
 * @date 2018/5/16 17:07
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        final String data = "123";
        byte[] buf = data.getBytes("utf-8");
        new DatagramSocket().send(new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.133"), 9099));
    }
}
