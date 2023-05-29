package indi.yucheng.netty.lighting.learing.chapter11.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class InboundHandlerC extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InboundHandlerC: " + msg);
        super.channelRead(ctx, msg);
        // 事件传播到 ChannelOutboundHandlerAdapter
        ctx.channel().writeAndFlush(ctx.alloc().buffer());
    }
}
