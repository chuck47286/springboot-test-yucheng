package indi.yucheng.netty.lighting.practice.base.data;

import indi.yucheng.netty.lighting.practice.base.serializer.Packet;
import lombok.Data;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    public MessageRequestPacket(){}

    public MessageRequestPacket(String line) {
        message = line;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
