package _netty_in_action._6_channelhandler_channelpipeline;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author 734070824@qq.com
 * @date 2018/6/4 20:35
 */
public class ServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        // 接受客户端的数据
        Integer body = (Integer) msg;
        System.out.println("Client :" + body.toString());
        // 服务端，回写数据给客户端
        // 直接回写整形的数据
        ctx.writeAndFlush(33);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}