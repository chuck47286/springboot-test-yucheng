package indi.yucheng.netty.lighting.learing.chapter13.data;

import indi.yucheng.netty.lighting.learing.chapter8.Packet;
import lombok.Data;

@Data
public class MessageResponsePacket extends Packet {

    private String message;
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
