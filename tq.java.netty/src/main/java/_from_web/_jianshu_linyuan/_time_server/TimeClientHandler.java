package _from_web._jianshu_linyuan._time_server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 * @author 734070824@qq.com
 * @date 2018/7/11 11:42
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter{


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf m = (ByteBuf) msg;

        try{
            long currentTimeMillis = (m.readUnsignedInt()) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();

        }finally {
            m.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
