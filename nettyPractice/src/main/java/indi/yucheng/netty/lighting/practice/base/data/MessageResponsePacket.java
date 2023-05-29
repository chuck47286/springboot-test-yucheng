package indi.yucheng.netty.lighting.practice.base.data;

import indi.yucheng.netty.lighting.practice.base.serializer.Packet;
import lombok.Data;

@Data
public class MessageResponsePacket extends Packet {

    private String message;
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
