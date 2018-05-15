package _netty_in_action._demo._udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/5/15 11:13
 */
public class UdpServer {

    public static void main(String[] args) throws InterruptedException {

        final NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioDatagramChannel.class);
            bootstrap.group(nioEventLoopGroup);
            bootstrap.handler(new UdpHandler());
            // 监听端口
            bootstrap.bind(9009).sync();
        } finally {
//            nioEventLoopGroup.shutdownGracefully().sync();
        }
    }
}
