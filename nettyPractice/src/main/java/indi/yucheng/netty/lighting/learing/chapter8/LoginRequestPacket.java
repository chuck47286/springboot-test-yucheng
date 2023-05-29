package indi.yucheng.netty.lighting.learing.chapter8;

import lombok.Data;

@Data
public class LoginRequestPacket extends Packet{

    private String userId;
    private String username;
    private String password;


    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
