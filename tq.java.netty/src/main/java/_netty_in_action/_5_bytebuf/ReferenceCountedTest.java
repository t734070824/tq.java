package _netty_in_action._5_bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import org.junit.Test;

/**
 * @author 734070824@qq.com
 * @date 2019/1/2 15:53
 */
public class ReferenceCountedTest {

    @Test
    public void first(){
        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.directBuffer();
        System.err.println(buffer.refCnt());

    }
}
