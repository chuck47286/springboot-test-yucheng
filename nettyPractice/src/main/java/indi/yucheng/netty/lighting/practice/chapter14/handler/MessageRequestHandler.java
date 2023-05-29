package indi.yucheng.netty.lighting.practice.chapter14.handler;

import indi.yucheng.netty.lighting.practice.base.data.MessageRequestPacket;
import indi.yucheng.netty.lighting.practice.base.data.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) throws Exception {
        ctx.channel().writeAndFlush(receiveMessage(messageRequestPacket));
    }

    private Object receiveMessage(MessageRequestPacket packet) {
        MessageRequestPacket messageRequestPacket = (MessageRequestPacket) packet;
        System.out.println(new Date() + " : 收到客户端消息： " + messageRequestPacket.getMessage());

        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复 【"+messageRequestPacket.getMessage()+"】done~");
        return messageResponsePacket;
    }
}
