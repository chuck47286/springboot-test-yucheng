package indi.yucheng.netty.lighting.learing.chapter8.bean;

public enum CommandEnum {
    LOGIN_REQUEST(Byte.valueOf("1")), LOGIN_RESPONSE(Byte.valueOf("2"));

    private Byte value;

    private CommandEnum(Byte value) {
        this.value = value;
    }

}
