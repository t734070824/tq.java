package _netty_in_action._bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * silce方法获取的ByteBuf仍然指向原来的buf
 */
public class ByteBuff_Slice {

    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!!", utf8);
        ByteBuf slice = buf.slice(0, 15);
        buf.setByte(0, (byte)'J');

        System.err.println((char)buf.getByte(0));
        System.err.println((char)slice.getByte(0));

    }
}
