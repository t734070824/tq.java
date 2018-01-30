package _netty_in_action._3_netty_module_design;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

@ChannelHandler.Sharable
public class EchoGetLengthServerHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        int length = in.readInt();
        System.err.println(length);
        super.channelRead(ctx, msg);
    }
}
