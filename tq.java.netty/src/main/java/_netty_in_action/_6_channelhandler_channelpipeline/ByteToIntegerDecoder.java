package _netty_in_action._6_channelhandler_channelpipeline;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/6/4 20:32
 */
public class ByteToIntegerDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in,
                          List<Object> out) throws Exception {
        // Check if there are at least 4 bytes readable
        if (in.readableBytes() >= 4) {
            int n = in.readInt();
            System.out.println("ByteToIntegerDecoder decode msg is " + n);
            // Read integer from inbound ByteBuf
            // add to the List of decodec messages
            out.add(n);
        }
    }
}
