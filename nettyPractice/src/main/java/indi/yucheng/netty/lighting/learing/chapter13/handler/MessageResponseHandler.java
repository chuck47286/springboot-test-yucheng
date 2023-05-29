package indi.yucheng.netty.lighting.learing.chapter13.handler;

import indi.yucheng.netty.lighting.learing.chapter10.data.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) throws Exception {
        ctx.channel().writeAndFlush(receiveMessage(messageResponsePacket));
    }

    private Object receiveMessage(MessageResponsePacket packet) {
        MessageResponsePacket messageResponsePacket =  (MessageResponsePacket) packet;
        System.out.println(new Date() + ": 收到服务端消息： " + messageResponsePacket.getMessage());
        return messageResponsePacket;
    }
}
