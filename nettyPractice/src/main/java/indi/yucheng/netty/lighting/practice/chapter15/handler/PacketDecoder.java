package indi.yucheng.netty.lighting.practice.chapter15.handler;

import indi.yucheng.netty.lighting.practice.base.serializer.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        out.add(PacketCodeC.getInstance().decode(in));
    }
}
