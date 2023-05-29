package indi.yucheng.netty.lighting.learing.chapter6;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    // 写数据逻辑
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println(new Date() + ": 客户端写出的数据");

        // 1.获取数据
        ByteBuf buffer = getByteBuf(ctx);
        // 2.写数据
        ctx.channel().writeAndFlush(buffer);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() +":客户端读到数据--》" + byteBuf.toString(Charset.forName("utf-8")));
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1.获取二进制抽象ByteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 2.准备数据，指定字符串的字符集UTF-8
        byte[] bytes = "你好，闪电侠！".getBytes(Charset.forName("utf-8"));
        // 3.填充数据到ByteBuf
        buffer.writeBytes(bytes);
        return buffer;
    }
}
