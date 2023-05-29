package indi.yucheng.netty.lighting.practice.base.data;

import indi.yucheng.netty.lighting.practice.base.serializer.Packet;
import lombok.Data;

@Data
public class LoginRequestPacket extends Packet {

    private String userId;
    private String username;
    private String password;


    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
