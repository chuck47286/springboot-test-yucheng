package indi.yucheng.netty.lighting.learing.chapter8;

import lombok.Data;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;
    private String username;
    private String password;
    private Boolean Success;
    private String Reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return this.Success;
    }
}
