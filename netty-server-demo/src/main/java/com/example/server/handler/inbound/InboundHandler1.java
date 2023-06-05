package com.example.server.handler.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author yucheng
 * @Date 2023/6/2 15:26
 * @Version 1.0
 */
@Slf4j
public class InboundHandler1 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("InboundHandler1.channelRead: ctx :" + ctx);
        // 通知执行下一个InboundHandler
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("InboundHandler1.channelReadComplete");
        ctx.flush();
    }
}
