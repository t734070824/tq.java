package _book._tcp_ip_illustrated._vol_1_the_protocols._20_tcp_block_data_flow;

import java.io.*;
import java.net.Socket;

/**
 * @author 734070824@qq.com
 * @date 2018/12/10 15:44
 */
public class TcpSharding {


    private static final int port = 8880;

    private static final String host = "192.168.1.133";

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(host, port);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1461 * 1; i++) {
            sb.append("1");
        }
        //向服务器端发送数据
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        out.write(sb.toString().getBytes());
        out.close();
    }
}
