package _netty_in_action._3_netty_module_design;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

@ChannelHandler.Sharable
public class EchoAddLengthServerHandler extends ChannelOutboundHandlerAdapter{

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ByteBuf out = (ByteBuf) msg;
        if(!(out instanceof EmptyByteBuf)){
            out.setInt(0, out.capacity());
            System.err.println(out.capacity());
        }
        super.write(ctx, msg, promise);

    }
}
