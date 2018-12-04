package _netty_in_action._demo._udp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author 734070824@qq.com
 * @date 2018/5/15 11:15
 */
public class UdpHandler extends SimpleChannelInboundHandler<DatagramPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg.copy().content();

        byte[] req = new byte[buf.readableBytes()];

        buf.readBytes(req);

        String body = new String(req, CharsetUtil.UTF_8);
        System.err.println(body);
        System.err.println(req.length);
        System.err.println("--------------");
    }
}
