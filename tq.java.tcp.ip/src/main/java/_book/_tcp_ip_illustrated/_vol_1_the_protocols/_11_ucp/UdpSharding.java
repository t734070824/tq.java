package _book._tcp_ip_illustrated._vol_1_the_protocols._11_ucp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * UDP数据分片 MTU 1500 1472数据
 * @author 734070824@qq.com
 * @date 2018/5/15 11:20
 */
public class UdpSharding {

    public static void main(String[] args) throws IOException, UnknownHostException {
        String data = "12";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30000; i++) {
            sb.append(data);
        }
        data = sb.toString();
        byte[] buf = data.getBytes("utf-8");
        System.err.println(buf.length);
        System.err.println(data);
        DatagramSocket socket = new DatagramSocket();
        socket.send(new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.1.133"), 9009));

    }
}
