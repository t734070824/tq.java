package _netty_in_action._2_first_netty_app;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    ByteBuf _in ;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        _in = in;
        System.err.println("server received: " + in.toString(CharsetUtil.UTF_8));
        //将接受到的消息写给发送方,而不冲刷出站消息??
        System.err.println(in.refCnt());
        ctx.write(msg);
        System.err.println(in.refCnt());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        将未决消息冲刷到远程节点,并关闭该Channel
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        System.err.println(_in.refCnt());
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
        System.err.println(_in.refCnt());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
