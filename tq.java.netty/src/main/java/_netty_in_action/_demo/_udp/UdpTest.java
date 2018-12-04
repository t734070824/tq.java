package _netty_in_action._demo._udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;

/**
 * @author 734070824@qq.com
 * @date 2018/5/15 11:20
 */
public class UdpTest {

    public static void main(String[] args) throws IOException, UnknownHostException {
        final String data = "123";
        byte[] buf = data.getBytes("utf-8");
        new DatagramSocket().send(new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.1.133"), 9009));
    }
}
