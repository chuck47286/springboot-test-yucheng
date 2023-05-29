package indi.yucheng.netty.lighting.learing.chapter13.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

public class FirstServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 接收数据逻辑
        ByteBuf bytebuf = (ByteBuf) msg;
        System.out.println(new Date() +":服务端读到数据 -->" +bytebuf.toString(Charset.forName("utf-8")));

        // 返回数据到客户端
        System.out.println(new Date() + ":服务端写出数据");
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        byte[] bytes = "您好，欢迎关注我的微信公众号，《闪电侠blog》!".getBytes(Charset.forName("utf-8"));
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }
}
