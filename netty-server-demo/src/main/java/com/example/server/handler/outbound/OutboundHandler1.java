package com.example.server.handler.outbound;

import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author yucheng
 * @Date 2023/6/2 15:46
 * @Version 1.0
 */
@Slf4j
public class OutboundHandler1 extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.info("OutboundHandler1.write");

        // 向client发送消息
        String response = "I am ok!";
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();//ctx.write()方法执行后，需要调用flush()方法才能令它立即执行
    }
}
