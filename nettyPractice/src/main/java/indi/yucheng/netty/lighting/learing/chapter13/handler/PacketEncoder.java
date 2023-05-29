package indi.yucheng.netty.lighting.learing.chapter13.handler;

import indi.yucheng.netty.lighting.learing.chapter8.Packet;
import indi.yucheng.netty.lighting.learing.chapter8.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder<Packet> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf out) throws Exception {
        PacketCodeC.getInstance().encode(out, packet);
    }
}
