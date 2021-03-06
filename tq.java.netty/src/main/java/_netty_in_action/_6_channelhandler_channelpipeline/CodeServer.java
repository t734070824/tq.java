package _netty_in_action._6_channelhandler_channelpipeline;

import _netty_in_action._2_first_netty_app.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class CodeServer {

    private final int port = 8080;

    public static void main(String[] args) throws InterruptedException {
        new CodeServer().start();
    }

    private void start() throws InterruptedException {
        //创建 EventLoop
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            //ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    //指定所使用的NIO传输Channel
                    .channel(NioServerSocketChannel.class)
                    //使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //添加一个EchoServerHandler 到 子Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //EchoServerHandler被标记为@Shareable 可以总是使用一个实例
                            ch.pipeline().addLast(new ByteToIntegerDecoder());
                            ch.pipeline().addLast(new IntegerToByteEncoder1());
                            ch.pipeline().addLast(new ServerHandler());
                        }
                    });

            //异步地绑定服务器；调用 sync()方法阻塞 等待直到绑定完成
            ChannelFuture sync = b.bind().sync();
            //获取 Channel 的CloseFuture，并且 阻 塞 当 前 线程直到它完成
            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
