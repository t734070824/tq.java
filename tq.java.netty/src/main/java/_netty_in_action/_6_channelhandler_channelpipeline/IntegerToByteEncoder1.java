package _netty_in_action._6_channelhandler_channelpipeline;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author 734070824@qq.com
 * @date 2018/6/4 20:32
 */
public class IntegerToByteEncoder1 extends MessageToByteEncoder<Integer> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Integer msg, ByteBuf out)
            throws Exception {
        System.out.println("IntegerToByteEncoder encode msg is " + msg);
        out.writeInt(msg);
    }
}
