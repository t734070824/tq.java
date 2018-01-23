package _netty_in_action._bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * set方法 以及 get方法 并不会改变readindex 和 writeindex
 */
public class ByteBuff_Get_Set {

    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!!", utf8);
        byte[] array = buf.array();
        System.err.println(buf.array().length);
        System.err.println(Arrays.toString(buf.array()));

        buf.setLong(0, 1);

        System.err.println(buf.array().length);
        System.err.println(Arrays.toString(buf.array()));

        buf.setLong(0, 2);

        System.err.println(buf.array().length);
        System.err.println(Arrays.toString(buf.array()));

    }
}
