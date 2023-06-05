package com.example.server.handler.inbound;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author yucheng
 * @Date 2023/6/2 15:26
 * @Version 1.0
 */
@Slf4j
public class InboundHandler2 extends ChannelInboundHandlerAdapter {
    @Override
    // 读取Client发送的信息，并打印出来
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("InboundHandler2.channelRead: ctx :" + ctx);
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");
        //buf.release();
        System.out.println("接收客户端数据:" + body);

        //向客户端写数据
        System.out.println("server向client发送数据");
        String currentTime = new Date(System.currentTimeMillis()).toString();
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp); //用ctx.write(msg) 将传递到 ChannelOutboundHandler
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("InboundHandler2.channelReadComplete");
        ctx.flush();
    }
}
