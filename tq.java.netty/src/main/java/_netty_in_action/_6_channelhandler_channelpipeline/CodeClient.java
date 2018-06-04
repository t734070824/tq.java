package _netty_in_action._6_channelhandler_channelpipeline;

import _netty_in_action._3_netty_module_design.EchoClientHandler;
import _netty_in_action._3_netty_module_design.EchoDemoClientHandler;
import _netty_in_action._3_netty_module_design.EchoGetLengthClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class CodeClient {

    private final int port = 8080;

    private final String host = "127.0.0.1";

    public static void main(String[] args) throws Exception {
        new CodeClient().start();
    }

    public void start() throws  Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ByteToIntegerDecoder());
                            ch.pipeline().addLast(new IntegerToByteEncoder2());
                            ch.pipeline().addLast(new IntegerToByteEncoder1());

                            ch.pipeline().addLast(new ClientHandler());

                        }
                    });
            ChannelFuture sync = b.connect().sync();
            sync.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully().sync();
        }
    }
}
