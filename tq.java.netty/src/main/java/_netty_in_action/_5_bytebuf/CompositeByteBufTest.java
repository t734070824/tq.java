package _netty_in_action._5_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.Test;

/**
 * @author 734070824@qq.com
 * @date 2019/1/2 10:59
 */
public class CompositeByteBufTest {

    @Test
    public void first(){
        ByteBuf hard = Unpooled.copiedBuffer("Netty rocks", CharsetUtil.UTF_8);
        ByteBuf tail = Unpooled.copiedBuffer("123", CharsetUtil.UTF_8);

        CompositeByteBuf byteBufs = Unpooled.compositeBuffer();
        byteBufs.addComponents(hard, tail);

        System.err.println(byteBufs.toString());

        for (ByteBuf byteBuf : byteBufs) {
            System.err.println(byteBuf.toString());
        }


    }


}
