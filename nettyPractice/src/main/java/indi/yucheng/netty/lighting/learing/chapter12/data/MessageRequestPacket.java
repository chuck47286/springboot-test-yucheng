package indi.yucheng.netty.lighting.learing.chapter12.data;

import indi.yucheng.netty.lighting.learing.chapter8.Packet;
import lombok.Data;

@Data
public class MessageRequestPacket extends Packet {

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
