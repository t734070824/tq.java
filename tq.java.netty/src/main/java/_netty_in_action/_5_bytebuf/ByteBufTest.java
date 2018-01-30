package _netty_in_action._5_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.Test;

public class ByteBufTest {

    @Test
    public void readableBytes(){
        ByteBuf buf = Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8);
        int i = buf.readableBytes();
        System.err.println(i);

    }


    @Test
    public void addAtHead(){
        ByteBuf buffer = Unpooled.buffer();
        String src = "Netty rocks";
        byte[] bytes = src.getBytes(CharsetUtil.UTF_8);
        buffer.writeInt(bytes.length);
        buffer.writeBytes(bytes);

        System.err.println(buffer.readInt());
        System.err.println(buffer.toString(CharsetUtil.UTF_8));

    }
}
