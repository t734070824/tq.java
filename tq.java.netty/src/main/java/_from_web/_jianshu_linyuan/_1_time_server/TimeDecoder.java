package _from_web._jianshu_linyuan._1_time_server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author 734070824@qq.com
 * @date 2018/7/11 15:15
 */
public class TimeDecoder extends ByteToMessageDecoder {



    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        out.add(in.readBytes(4));
        out.add(1111);
    }
}
