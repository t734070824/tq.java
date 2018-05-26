package _netty_in_action._3_netty_module_design;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

@ChannelHandler.Sharable
public class EchoDemoServerHandler extends ChannelOutboundHandlerAdapter{

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.err.println("EchoDemoServerHandler");
        super.write(ctx, msg, promise);

        /**
         * 有两次输出 EchoDemoServerHandler 的原因是因为
         * 在 EchoServerHandler.channelReadComplete()还会触发一次写出消息
         *
         */
    }
}
