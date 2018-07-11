package _from_web._jianshu_linyuan._time_server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author 734070824@qq.com
 * @date 2018/7/11 13:35
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        int port = 9090;
        String host = "localhost";
        EventLoopGroup workerGropp = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGropp)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TimeDecoder(), new TimeClientHandler());
                        }
                    });
            ChannelFuture future = bootstrap.connect(host, port).sync();
            //等待客户端连接端口关闭
            future.channel().closeFuture().sync();
        }finally {
            workerGropp.shutdownGracefully();
        }
    }

}
