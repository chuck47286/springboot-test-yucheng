package com.example.server.handler.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author yucheng
 * @Date 2023/6/2 15:46
 * @Version 1.0
 */
@Slf4j
public class OutboundHandler2 extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.info("OutboundHandler2.write");
        super.write(ctx, msg, promise);// 执行下一个OutboundHandler
    }
}
